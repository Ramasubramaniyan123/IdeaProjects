
import { useEffect, useState } from "react";

export default function Admin() {
  const [items, setItems] = useState([]);

  const load = async () => {
    const r = await fetch("http://localhost:8080/api/feedback");
    setItems(await r.json());
  };

  useEffect(() => { load(); }, []);

  const update = async (id, status) => {
    await fetch(`http://localhost:8080/api/feedback/${id}/status?status=${status}`, {method:"PUT"});
    load();
  };

  return (
    <div className="container">
      <h2>Admin Dashboard</h2>
      <table>
        <thead>
          <tr><th>ID</th><th>Type</th><th>Message</th><th>Status</th><th>Action</th></tr>
        </thead>
        <tbody>
          {items.map(i => (
            <tr key={i.id}>
              <td>{i.id}</td>
              <td>{i.type}</td>
              <td>{i.message}</td>
              <td>{i.status}</td>
              <td>
                <button onClick={() => update(i.id,"IN_PROGRESS")}>Start</button>
                <button onClick={() => update(i.id,"RESOLVED")}>Resolve</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

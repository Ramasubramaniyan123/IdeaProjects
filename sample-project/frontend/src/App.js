
import { useEffect, useState } from "react";
const EMAIL = "user@test.com";

export default function App() {
  const [message, setMessage] = useState("");
  const [type, setType] = useState("SUGGESTION");
  const [items, setItems] = useState([]);

  const load = async () => {
    const r = await fetch("http://localhost:8080/api/feedback/user/" + EMAIL);
    setItems(await r.json());
  };

  useEffect(() => { load(); }, []);

  const submit = async () => {
    await fetch("http://localhost:8080/api/feedback", {
      method: "POST",
      headers: {"Content-Type":"application/json"},
      body: JSON.stringify({name:"User", email:EMAIL, type, message})
    });
    setMessage("");
    load();
  };

  return (
    <div className="container">
      <h2>User Feedback</h2>
      <select onChange={e => setType(e.target.value)}>
        <option>SUGGESTION</option>
        <option>COMPLAINT</option>
      </select>
      <br/><br/>
      <textarea value={message} onChange={e => setMessage(e.target.value)} />
      <br/><br/>
      <button onClick={submit}>Submit</button>

      <h3>My Submissions</h3>
      <table>
        <thead>
          <tr><th>ID</th><th>Type</th><th>Message</th><th>Status</th></tr>
        </thead>
        <tbody>
          {items.map(i => (
            <tr key={i.id}>
              <td>{i.id}</td>
              <td>{i.type}</td>
              <td>{i.message}</td>
              <td>{i.status}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

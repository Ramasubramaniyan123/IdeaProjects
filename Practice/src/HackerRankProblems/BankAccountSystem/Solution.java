package HackerRankProblems.BankAccountSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> processCommands(List<String> commands) {
        TransactionHistory history = new TransactionHistory();
        BankAccountCaretaker caretaker = new BankAccountCaretaker();
        BankAccount account = new BankAccount(history, caretaker);

        List<Integer> allCommandsResults = new ArrayList<>();
        for (int i = 0; i < commands.size(); i++) {
            String command = commands.get(i);
            String[] commandInstructions = command.split(" ");
            String action = commandInstructions[0].trim();
            Integer amount = commandInstructions.length > 1 ? Integer.valueOf(commandInstructions[1].trim()) : null;

            if (action.equals("deposit")) {
                account.deposit(amount);
            } else if (action.equals("withdraw")) {
                account.withdraw(amount);
            } else if (action.equals("undo")) {
                account.undo();
            } else if (action.equals("getBalance")) {
                allCommandsResults.add(account.getBalance());
            }
        }
        return allCommandsResults;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter =
                new BufferedWriter(new OutputStreamWriter(System.out));

        int commandsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> commands = new ArrayList<>();

        for (int i = 0; i < commandsCount; i++) {
            String commandsItem = bufferedReader.readLine();
            commands.add(commandsItem);
        }

        List<Integer> result = Solution.processCommands(commands);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
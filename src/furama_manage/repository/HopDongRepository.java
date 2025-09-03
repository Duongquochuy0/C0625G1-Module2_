package furama_manage.repository;

import furama_manage.entity.Contract;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HopDongRepository {
    private static final String FILE_PATH = "furama_manage/data/contract.csv";
    private static List<Contract> contracts;

    static {
        contracts = new ArrayList<>();
        readContractsFromFile();
    }

    private static void readContractsFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    contracts.add(new Contract(data[0], data[1], data[2], data[3]));
                }
            }
        } catch (IOException e) {
            System.err.println("Không thể đọc file contract.csv: " + e.getMessage());
        }
    }

    public void addContract(Contract contract) {
        contracts.add(contract);
        saveContractsToFile();
    }

    public List<Contract> getAllContracts() {
        return new ArrayList<>(contracts);
    }

    private void saveContractsToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Contract contract : contracts) {
                bw.write(contract.toCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Không thể ghi file contract.csv: " + e.getMessage());
        }
    }
}

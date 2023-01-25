package pjwstk.Bank;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransferStorage {

    List<Transfer> transfers = new ArrayList<>();

    public void addTransfer(Transfer transfer) {
        transfers.add(transfer);
    }
    public List<Transfer> getAllTransfers() {
        return transfers;
    }
}

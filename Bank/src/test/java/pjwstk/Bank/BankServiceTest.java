package pjwstk.Bank;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class BankServiceTest {
    @Mock
    private TransferStorage transferStorage;
    @Mock
    private ClientStorage clientStorage;
    @InjectMocks
    private BankService bankService;

    @Test
    public void doesClientExist() {
        Transfer transfer = new Transfer(0, "DECLINED");
        when(clientStorage.findClientById(any())).thenReturn(null);
        assertThat(bankService.transfer("1939", 17).getStatus()).isEqualTo(transfer.getStatus());
    }

    @Test
    public void minusBalance() {
        Client client = new Client("14", 13.50);
        when(clientStorage.findClientById("14")).thenReturn(client);
        assertThat(bankService.transfer("14", 13.51).getStatus()).isEqualTo(new Transfer(13.51, "DECLINED").getStatus());
    }

    @Test
    public void positiveBalance() {
        Client client = new Client("14", 31.94);
        when(clientStorage.findClientById("14")).thenReturn(client);
        assertThat(bankService.transfer("14", 31.94).getStatus()).isEqualTo(new Transfer(31.94, "ACCEPTED").getStatus());
    }

    @Test
    public void negativeDeposit() {
        Client client = new Client("14", 111111.11);
        when(clientStorage.findClientById("14")).thenReturn(client);
        assertThat(bankService.deposit("14", -4324234).getStatus()).isEqualTo(new Transfer(-4324234, "DECLINED").getStatus());
    }

    @Test
    public void negativeDepositNoUser() {
        Transfer transfer = new Transfer(0, "DECLINED");
        when(clientStorage.findClientById(any())).thenReturn(null);
        assertThat(bankService.deposit("1939", -17).getStatus()).isEqualTo(transfer.getStatus());
    }
}

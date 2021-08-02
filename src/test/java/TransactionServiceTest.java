import com.crowdcube.model.Customer;
import com.crowdcube.model.Product;
import com.crowdcube.model.Transaction;
import com.crowdcube.model.repository.TransactionRepository;
import com.crowdcube.services.impl.TransactionServiceImpl;
import edu.emory.mathcs.backport.java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class TransactionServiceTest {

    @InjectMocks
    TransactionServiceImpl transactionService;

    @Mock
    TransactionRepository transactionRepository;

    Customer customer;
    Product product;
    Transaction transaction;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        customer = Customer.builder()
                .id(Long.valueOf(1))
                .build();

        product = Product.builder()
                .id(Long.valueOf(1))
                .name("MyProduct")
                .build();

        transaction = Transaction.builder()
                .customer(customer)
                .product(product)
                .id(Long.valueOf(1))
                .price(1.0)
                .quantity(BigDecimal.ONE)
                .build();
    }

    @Test
    void getAllTransactionByCustomer() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);

        when(transactionRepository.findAllByCustomerId(anyLong())).thenReturn(transactions);

        List<Transaction> result = transactionService.getAll(Long.valueOf(1));
        assertEquals(1, result.size());
    }
}

import com.crowdcube.model.PaymentMethod;
import com.crowdcube.model.repository.PaymentMethodRepository;
import com.crowdcube.services.impl.PaymentMethodServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class PaymentMethodServiceTest {

    @InjectMocks
    PaymentMethodServiceImpl paymentMethodService;

    @Mock
    PaymentMethodRepository paymentMethodRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void createPaymentMethod(){
        Long id = Long.valueOf(1);
        String cardNumber = "1234123412341234";
        String expiryDate = "04/21";
        String ccv = "012";

        PaymentMethod pm = PaymentMethod.builder()
                .id(id)
                .cardNumber(cardNumber)
                .type(PaymentMethod.PaymentType.STRIPE)
                .expiryDate(expiryDate)
                .ccv(ccv)
                .build();

        when(paymentMethodRepository.save(any())).thenReturn(pm);



        PaymentMethod result = paymentMethodService.create(PaymentMethod.PaymentType.STRIPE, cardNumber, expiryDate, ccv);

        assertNotNull(result);
        assertEquals(result.getId(), pm.getId());
        assertEquals(PaymentMethod.PaymentType.STRIPE, result.getType());
        assertEquals(cardNumber, result.getCardNumber());
        assertEquals(expiryDate, result.getExpiryDate());
        assertEquals(ccv, result.getCcv());
    }

    @Test
    void updatePaymentMethod(){
        Long id = Long.valueOf(1);
        String cardNumber = "1234123412341234";
        String expiryDate = "04/21";
        String ccv = "012";
        String updatedCcv = "123";

        PaymentMethod pm = PaymentMethod.builder()
                .id(id)
                .cardNumber(cardNumber)
                .type(PaymentMethod.PaymentType.STRIPE)
                .expiryDate(expiryDate)
                .ccv(ccv)
                .build();

        when(paymentMethodRepository.save(any())).thenReturn(pm);

        pm.setCcv(updatedCcv);
        PaymentMethod updatedResult = paymentMethodService.update(pm);

        assertNotNull(updatedResult);
        assertEquals(id, updatedResult.getId());
        assertEquals(PaymentMethod.PaymentType.STRIPE, updatedResult.getType());
        assertEquals(cardNumber, updatedResult.getCardNumber());
        assertEquals(expiryDate, updatedResult.getExpiryDate());
        assertEquals(updatedCcv, updatedResult.getCcv());
    }

    @Test
    void deletePaymentMethod(){
        Long id = Long.valueOf(1);

        Optional<PaymentMethod> result = Optional.empty();
        when(paymentMethodRepository.findById(anyLong())).thenReturn(result);

        boolean isDeleted = paymentMethodService.delete(id);
        assertTrue(isDeleted);
    }
}

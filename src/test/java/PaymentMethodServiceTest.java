import com.crowdcube.model.PaymentMethod;
import com.crowdcube.services.PaymentMethodService;
import com.crowdcube.services.impl.PaymentMethodServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PaymentMethodServiceTest {

    PaymentMethodService paymentMethodService;

    @BeforeEach
    void setUp() {
        paymentMethodService = new PaymentMethodServiceImpl();
    }

    @Test
    void createPaymentMethod(){
        String cardNumber = "1234123412341234";
        String expiryDate = "04/21";
        String ccv = "012";

        PaymentMethod pm = paymentMethodService.create(PaymentMethod.PaymentType.STRIPE, cardNumber, expiryDate, ccv);

        assertNotNull(pm);
        assertEquals(PaymentMethod.PaymentType.STRIPE, pm.getType());
        assertEquals(cardNumber, pm.getCardNumber());
        assertEquals(expiryDate, pm.getExpiryDate());
        assertEquals(ccv, pm.getCcv());
    }
}

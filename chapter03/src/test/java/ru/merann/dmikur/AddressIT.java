package ru.merann.dmikur;

import org.junit.Ignore;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;
/**
 * Created by manya on 27.07.2015.
 */
public class AddressIT {
    @Ignore
    @Test
    public void shouldRaiseConstraintViolationCasuseInvalidZipCode() {
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();
        Address address = new Address("233 Street", "New-York", "NY", "DummyZip", "USA");
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        assertEquals(1, violations.size());
        vf.close();
    }
}

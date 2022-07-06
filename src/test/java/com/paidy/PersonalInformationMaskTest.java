package com.paidy;

import com.paidy.informationmask.MaskManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @created 2022/7/6
 */
public class PersonalInformationMaskTest {

  @Test
  public void emailTest() {
    PersonalInformationMask mask = new PersonalInformationMask();
    assertEquals("a*****c@gmail.com", mask.execute("abc@gmail.com"));
    assertEquals("s*****e@example.com", mask.execute("simple@example.com"));
    assertEquals("a*****c@example.co.uk", mask.execute("ac@example.co.uk"));
    assertEquals(
        "e*****d@strange-example.inininini",
        mask.execute("example-indeed@strange-example.inininini"));
    assertEquals(
        "1*****x@example.com",
        mask.execute(
            "1234567890123456789012345678901234567890123456789012345678901234+x@example.com"));

    IllegalArgumentException exception =
        assertThrows(IllegalArgumentException.class, () -> mask.execute("@gmail.com"));
    assertEquals(MaskManager.ERR_MSG, exception.getMessage());
  }

  @Test
  public void phoneNumberTest() {
    PersonalInformationMask mask = new PersonalInformationMask();

    assertEquals("+**-***-****-4613", mask.execute("+81 070 4406 4613"));
    assertEquals("+**-*******4613", mask.execute("+81 07044064613"));
    assertEquals("+**-**-***-0605", mask.execute("+84 35 539 0605"));
    assertEquals("+**-**-***0-605", mask.execute("+84 35 5390 605"));
    assertEquals("+*-**-***-0605", mask.execute("+1 35 539 0605"));
    assertEquals("+*-***-**0-605", mask.execute("+1 355 390 605"));
    assertEquals("**-***-**0-605", mask.execute("81 355 390 605"));
    assertEquals("**-***-****-4613", mask.execute("81 070 4406 4613"));

    IllegalArgumentException exception =
        assertThrows(IllegalArgumentException.class, () -> mask.execute("81+ 070 4406 4613"));
    assertEquals(MaskManager.ERR_MSG, exception.getMessage());
    exception = assertThrows(IllegalArgumentException.class, () -> mask.execute("+81 123456"));
    assertEquals(MaskManager.ERR_MSG, exception.getMessage());
  }
}

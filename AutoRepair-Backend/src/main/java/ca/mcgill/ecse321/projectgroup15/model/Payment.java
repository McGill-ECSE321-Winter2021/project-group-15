package ca.mcgill.ecse321.projectgroup15.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Payment
{

  private String cardName;
  private String cardNumber;
  private String expirationDate;
  private int cvc;
  private String paymentId;

  

  public boolean setCardName(String aCardName)
  {
    boolean wasSet = false;
    cardName = aCardName;
    wasSet = true;
    return wasSet;
  }

  public boolean setCardNumber(String aCardNumber)
  {
    boolean wasSet = false;
    cardNumber = aCardNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setExpirationDate(String aExpirationDate)
  {
    boolean wasSet = false;
    expirationDate = aExpirationDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setCvc(int aCvc)
  {
    boolean wasSet = false;
    cvc = aCvc;
    wasSet = true;
    return wasSet;
  }

  public boolean setPaymentId(String aPaymentId)
  {
    boolean wasSet = false;
    paymentId = aPaymentId;
    wasSet = true;
    return wasSet;
  }

  public String getCardName()
  {
    return cardName;
  }

  public String getCardNumber()
  {
    return cardNumber;
  }

  public String getExpirationDate()
  {
    return expirationDate;
  }

  public int getCvc()
  {
    return cvc;
  }
@Id
  public String getPaymentId()
  {
    return paymentId;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "cardName" + ":" + getCardName()+ "," +
            "cardNumber" + ":" + getCardNumber()+ "," +
            "expirationDate" + ":" + getExpirationDate()+ "," +
            "cvc" + ":" + getCvc()+ "," +
            "paymentId" + ":" + getPaymentId()+ "]";
  }
}
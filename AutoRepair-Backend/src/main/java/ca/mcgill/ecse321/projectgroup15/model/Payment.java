/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/



// line 11 "model.ump"
// line 126 "model.ump"
public class Payment
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Payment Attributes
  private String cardName;
  private String cardNumber;
  private String expirationDate;
  private int cvc;
  private String paymentId;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Payment(String aCardName, String aCardNumber, String aExpirationDate, int aCvc, String aPaymentId)
  {
    cardName = aCardName;
    cardNumber = aCardNumber;
    expirationDate = aExpirationDate;
    cvc = aCvc;
    paymentId = aPaymentId;
  }

  //------------------------
  // INTERFACE
  //------------------------

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
package EnumType;

public class MainTest {

    public static void main(String[] args) {
//useConstantMethod(1);
//useConstantMethod(2);
//useConstantMethod(3);
//useConstantMethod(4);
//useConstantMethod(100);
//useConstantMethod(5);


useEnumMethod(TransactionType.DEPOSIT);
useEnumMethod(TransactionType.PAYMENT);
useEnumMethod(TransactionType.WITHDRAW);
useEnumMethod(TransactionType.OTHER);
//useEnumMethod(TransactionType.a); enum dışında yazmamıza izin vermez

    }
    //eski tarz
    private static void useConstantMethod(int i) {
        if (i == TransactionTypeConstant.DEPOSIT) {
            System.out.println("Money is Depositing");
           }else if (i == TransactionTypeConstant.WITHDRAW){
            System.out.println("Money is Withdrawing");
        }else if (i == TransactionTypeConstant.TRANSFER){
            System.out.println("Money is Transfering");
            } else if (i== TransactionTypeConstant.PAYMENT) {
            System.out.println("Money is Payment");
        }else if(i==TransactionTypeConstant.OTHER) {
            System.out.println("other");
        }
    }


    // enum yapısı ile
    private static void useEnumMethod(TransactionType transactionType){
        if(transactionType==TransactionType.DEPOSIT){
            System.out.println("Money is DePOSIT");
        } else if (transactionType==TransactionType.PAYMENT) {
            System.out.println("Money is DePAYMENT");

        } else if (transactionType==TransactionType.TRANSFER) {
            System.out.println("Money is DeTRANSFER");

        } else if (transactionType==TransactionType.WITHDRAW) {
            System.out.println("Money is DeWITHDRAW");
            } else if (transactionType==TransactionType.OTHER) {
            System.out.println("money is Other");

        }
        System.out.println("Enum name= " +transactionType.name());// enum ismini ekran yazdıran
        System.out.println("Enum code value= " +transactionType.getTransactionCode());//enum a tanımlı code getir methogu ile çağırırız
        System.out.println("Enum ordinal= " +transactionType.ordinal());//enum a tanımlı code getir methogu ile çağırırız
    }

}

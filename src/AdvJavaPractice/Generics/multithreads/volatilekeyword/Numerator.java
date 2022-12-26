package AdvJavaPractice.Generics.Multithreading.volatilekeyword;

import javax.xml.namespace.QName;

public class Numerator {
    private volatile static int counter=0;
    //volatile keyvwordu değişkenin main memory' de saklanmasını garanti eder ancak tüm trheadlerin
    // değişkeni aynı anda ulaşmasından kaynaklı çakışmaya çözme garantisi yoktur'
    //bunun için synchronized keywordü de kullanılmalı
    public   void getOrder(){
        counter++;
        String name=Thread.currentThread().getName();

        System.out.println("Sayın  ;"+ name+" numaranız:  "+counter);

    }
}

package Synchronize;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class printABC {

    public static void main(String[] args) {
        printABC ABC = new printABC();
        LetterPrinter letterPrinter = ABC.new LetterPrinter();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(ABC.new Syn(letterPrinter,'A'));
        executorService.execute(ABC.new Syn(letterPrinter,'B'));
        executorService.execute(ABC.new Syn(letterPrinter,'C'));
//        Thread thread1 = new Thread( new Syn(letterPrinter,'A'));
//        Thread thread2 = new Thread( new Syn(letterPrinter,'B'));
//        Thread thread3 = new Thread( new Syn(letterPrinter,'C'));

    }
    private  class LetterPrinter{
        private char letter = 'A';
        private char getLetter(){
            return letter;
        }
        public void print(){
            System.out.println(letter);
        }
        public void nextLetter(){
            switch (letter){
                case 'A':
                    letter = 'B';
                    break;
                case 'B':
                    letter = 'C';
                    break;
                case 'C':
                    letter = 'A';
                    break;

            }
        }
    }

    private class Syn implements Runnable{
        private LetterPrinter letterPrinter = null;
        private char letter = ' ';
        public Syn(LetterPrinter letterPrinter,char letter){
            super();
            this.letterPrinter = letterPrinter;
            this.letter = letter;
        }

        @Override
        public void run() {
            for(int i = 0 ; i<10;i++){
                synchronized (letterPrinter){
                    while(letter!=letterPrinter.getLetter()){
                        try {
                            letterPrinter.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    letterPrinter.print();
                    letterPrinter.nextLetter();
                    letterPrinter.notifyAll();
                }

            }
        }
    }
}

package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
	// запись и чтение фаилов
    // Классы Date и Calendar
        // FileWriter
        FileWriter fw= new FileWriter("1.txt");
        fw.write("Hello!!!\n");
        char [] shars={'1','2','3','k','\n'};
        fw.write(shars);
        fw.write("Privet",1,3);//riv
        fw.write(shars,2,2);//23k
        fw.flush();
        fw.close();
        // открытие фаила в режиме добавления
        FileWriter fw2= new FileWriter("2.txt",true);
        fw2.write("sam takoy\n");
        fw2.flush();
        fw2.close();
        // r- только для чтения
        // w- только для записит
        // rw - чтение и  запись
        RandomAccessFile file= new RandomAccessFile("2.txt","rw");
        file.seek(6);// смещение курсора в фаиле
        file.writeChars("   adcd   ");
        file.close();
        FileReader fr = new FileReader("1.txt");
        char[] data=new char[15];
        fr.read(data);
        System.out.print(new String(data));
       while (true){
        int c =fr.read();
        if (c==-1) {// конец фаила
            break;
        }
           System.out.print((char)c);
       }
        fr.close();
       //Сереиализация (Serializotion) - проццесс представления объекта в ввиде двоичных  данных
        //(как он хронится в оперативной памяти)
       /* Person p = new Person();
        p.setAge(28) ;
        p.name ="Vasya";
      //  if(p instanceof Serializable){}
       FileOutputStream fos =new FileOutputStream("data.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(p);
        oos.writeInt(1200);
        oos.flush();
        oos.close();
        fos.flush();

        fos.close(); // закрываются в обратном порядке (чем позже тем раньше)*/

        FileInputStream fis = new FileInputStream("data.bin");
        ObjectInputStream ois =new ObjectInputStream(fis);
        // чтение (десириализация) фаила должна происходить в том же порядке что и запись
       Person p2 = (Person) ois.readObject();
       int n = ois.readInt();
       ois.close();
       fis.close();
        System.out.println(p2);
        System.out.println(n);

    }
}

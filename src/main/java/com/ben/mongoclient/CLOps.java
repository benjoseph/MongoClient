package com.ben.mongoclient;

import java.util.Scanner;

public class CLOps {
	
	int crudchoice;
	
	public void interact(){
	Scanner s=new Scanner(System.in);
	System.out.println("1.Insert Test Data 2.Options 3.generate test data 4.Read test");
	int mainchoice=s.nextInt();
	if(mainchoice==1){
		TestData ob=new TestData();
		ob.insert();
	}else if(mainchoice==3){
		
		
		GenTestData test=new GenTestData();
		test.generate();
	}else if(mainchoice==4){
		
		ReadPerfTest rdtest=new ReadPerfTest();
		rdtest.runtest();
		
	}else	{
	
		ConfigManager config=ConfigManager.get();
		CRUD db=config.connection();
		db.createconn();
		int crudchoice;
		Device d=new Device();
		do{
			System.out.println("1.Insert 2.Search 3.Modify 4.Delete 5.Exit");
			crudchoice=s.nextInt();
			String UDID;
			switch(crudchoice){
			case 1:System.out.println("Enter UDID");
			       d.UDID=s.next();
			       s.nextLine();
			       System.out.println("Enter Friendlyname");
			       d.FriendlyName=s.nextLine();
			       System.out.println("Enter serial number");
			       d.sn=s.next();
			       System.out.println("Enter Manf Date");
			       d.ManDate=s.next();
			       
			       db.create(d);
			       break;
			       
			       
			case 2:System.out.println("Enter UDID");
				   UDID=s.next();
				   d=db.read(UDID);
				   d.display();
				   break;
				   
			case 3:System.out.println("Enter UDID");
			       d.UDID=s.next();
			       System.out.println("Enter Friendlyname");
			       d.FriendlyName=s.next();
			       System.out.println("Enter serial number");
			       d.sn=s.next();
			       System.out.println("Enter Manf Date");
			       d.ManDate=s.next();
			       d.display();
			       db.update(d);
			       break;
			case 4:System.out.println("Enter UDID");
			       UDID=s.next();
			       db.delete(UDID);
			       break;
			       
			      
			       
			}
			
		}while(crudchoice!=5);
	}
	
	
	
	s.close();
  }
}

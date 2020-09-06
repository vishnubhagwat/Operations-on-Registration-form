package com.hibernate.client;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.model.Address;
import com.hibernate.model.EducationalDetails;
import com.hibernate.model.PersonalDetails;
import com.hibernate.model.Profile;

public class Client extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
	JTextField f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15;
	JPanel p1,p2,p3;
	JButton b1,b2,b3,b4;
	
	public Client()
	{
		f1 = new JTextField(20);
		f2 = new JTextField(20);
		f3 = new JTextField(20);
		f4 = new JTextField(20);
		f5 = new JTextField(20);
		f6 = new JTextField(20);
		f7 = new JTextField(20);
		f8 = new JTextField(20);
		f9 = new JTextField(20);
		f10 = new JTextField(20);
		f11 = new JTextField(20);
		f12 = new JTextField(20);
		f13 = new JTextField(20);
		f14 = new JTextField(20);
		f15 = new JTextField(20);
		
		l1 = new JLabel("Profile Id");
		l2 = new JLabel("CreationDate");
		l3 = new JLabel("Qualification");
		l4 = new JLabel("Result");
		l5 = new JLabel("Year");
		l6 = new JLabel("BirthDate");
		l7 = new JLabel("ContactNo");
		l8 = new JLabel("Email");
		l9 = new JLabel("FirstName");
		l10 = new JLabel("Gender");
		l11 = new JLabel("LastName");
		l12 = new JLabel("City");
		l13 = new JLabel("Country");
		l14 = new JLabel("Street");
		l15 = new JLabel("Zip");
		
		b1 = new JButton("Add");
		b2 = new JButton("Update");
		b3 = new JButton("Search");
		b4 = new JButton("Delete");
		
		p1 = new JPanel(new GridLayout(15,2));
		p2 = new JPanel(new GridLayout(2,2));
		p3 = new JPanel(new GridLayout(2,1));
		
		add(l1);add(f1);add(l2);add(f2);add(l3);add(f3);add(l4);add(f4);
		add(l5);add(f5);add(l6);add(f6);add(l7);add(f7);add(l8);add(f8);add(l9);add(f9);add(l10);add(f10);
		add(l11);add(f11);add(l12);add(f12);add(l13);add(f13);add(l14);add(f14);
		add(l15);add(f15);
	add(b1);add(b2);add(b3);add(b4);
	
	
	p1.add(l1);p1.add(f1);p1.add(l2);p1.add(f2);p1.add(l3);p1.add(f3);p1.add(l4);p1.add(f4);
		p1.add(l5);p1.add(f5);p1.add(l6);p1.add(f6);p1.add(l7);p1.add(f7);p1.add(l8);p1.add(f8);p1.add(l9);p1.add(f9);p1.add(l10);p1.add(f10);
		p1.add(l11);p1.add(f11);p1.add(l12);p1.add(f12);p1.add(l13);p1.add(f13);p1.add(l14);p1.add(f14);
		p1.add(l15);p1.add(f15);
		
		p2.add(b1);	p2.add(b2);	p2.add(b3);	p2.add(b4);
		
		p3.add(p1);
		p3.add(p2);
		
		this.add(p3);
		
		b1.addActionListener(this);
		b4.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		this.setVisible(true);
		this.setLayout(new FlowLayout());
		this.setSize(600,550);
		
	}
	
	public void actionPerformed(ActionEvent ae) 
	{
		int ProfileId = Integer.parseInt(f1.getText());		
		String CDate = f2.getText();
		String Qualification = f3.getText();
		String Result = f4.getText();
		
		String BirthDate = f6.getText();
		String ContactNo = f7.getText();
		String Email = f8.getText();
		String FName = f9.getText();
		String Gender = f10.getText();
		String LName = f11.getText();
		String City = f12.getText();
		String Country = f13.getText();
		String Street = f14.getText();
		String Zip = f15.getText();
		
		if(ae.getSource() == b1)
		{
			int Year = Integer.parseInt(f5.getText());
			System.out.println("year in b1 "+Year);
		try
		{
		Configuration config = new Configuration().configure();
		ServiceRegistry registry=new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory factory = config.buildSessionFactory(registry);
		Session session = factory.getCurrentSession();
		Transaction txn = session.beginTransaction();
		
		Profile pro = new Profile();
		pro.setProfileId(ProfileId);
		//Date d1 = new Date(2002,02,02);
		pro.setCreationDate(CDate);
		Address a = new Address(Street,City,Country,Zip);
		PersonalDetails p = new PersonalDetails(FName,LName,ContactNo,Email,Gender,BirthDate,a);
		pro.setPerInfo(p);
		
		EducationalDetails e = new EducationalDetails(Qualification,Result,Year);
		pro.setEduInfo(e);
		
		session.save(pro);
		
		txn.commit();
		
		}
		catch(Exception e)
		{
			System.out.println("this is si "+e);
			
		}
		}
		
		if(ae.getSource() == b4)
		{
			try
			{
			Configuration config = new Configuration().configure();
			ServiceRegistry registry=new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			SessionFactory factory = config.buildSessionFactory(registry);
			Session session = factory.getCurrentSession();
			Transaction txn = session.beginTransaction();
			
			Profile pro = (Profile)session.get(Profile.class,ProfileId);
			session.delete(pro);
			
			/*Profile pro = new Profile();
			pro.setProfileId(ProfileId);
			//Date d1 = new Date(2002,02,02);
			pro.setCreationDate(CDate);
			Address a = new Address(Street,City,Country,Zip);
			PersonalDetails p = new PersonalDetails(FName,LName,ContactNo,Email,Gender,BirthDate,a);
			pro.setPerInfo(p);
			
			EducationalDetails e = new EducationalDetails(Qualification,Result,Year);
			pro.setEduInfo(e);
			
			session.save(pro);
			*/
			txn.commit();
			
			}
			catch(Exception e)
			{
				System.out.println("this is si "+e);
				
			}
			
			
		}
		if(ae.getSource() == b2)
		{
			System.out.println("q "+ProfileId);
			System.out.println("q "+Qualification);
			System.out.println("q "+Qualification);
			System.out.println("d"+CDate);
			System.out.println("r"+Result);
			System.out.println("b"+BirthDate);
			System.out.println("c"+ContactNo);
			System.out.println(Email);
			System.out.println(FName);
			System.out.println(Gender);
			System.out.println(LName);
			System.out.println(City);
			System.out.println(Country);
			System.out.println(Street);
			System.out.println(Zip);
		//	System.out.println(Qualification);
			//System.out.println(Qualification);
			PersonalDetails p = new PersonalDetails();
			EducationalDetails e = new EducationalDetails();
			Address a = new Address();
			
			try
			{
			Configuration config = new Configuration().configure();
			ServiceRegistry registry=new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			SessionFactory factory = config.buildSessionFactory(registry);
			Session session = factory.getCurrentSession();
			Transaction txn = session.beginTransaction();
			
			Profile pro = (Profile)session.get(Profile.class, ProfileId);
			
			
			
				e.setQualification(Qualification);
				pro.setEduInfo(e);
				session.update(pro);
			
				
				pro.setCreationDate(CDate);
				session.update(pro);
			
				
				e.setResult(Result);
				pro.setEduInfo(e);
				session.update(pro);
			
				int Year;
				
				 Year = Integer.parseInt(f5.getText());
				
				e.setYearPassing(Year);
				pro.setEduInfo(e);
				session.update(pro);
			
				p.setBirthDate(BirthDate);
				pro.setPerInfo(p);
				session.update(pro);

				p.setContactNo(ContactNo);
				pro.setPerInfo(p);
				session.update(pro);
				
				p.setEmail(Email);
				pro.setPerInfo(p);
				session.update(pro);
				
				p.setFirstName(FName);
				pro.setPerInfo(p);
				session.update(pro);
				
				p.setGender(Gender);
				pro.setPerInfo(p);
				session.update(pro);

				p.setLastName(LName);
				pro.setPerInfo(p);
				session.update(pro);
				
			
				a.setCity(City);
				p.setResAddr(a);
				pro.setPerInfo(p);
				session.update(pro);
				
				//Address a = new Address();
				a.setCountry(Country);
				p.setResAddr(a);
				pro.setPerInfo(p);
				session.update(pro);
				
				//Address a = new Address();
				a.setStreet(Street);
				p.setResAddr(a);
				pro.setPerInfo(p);
				session.update(pro);
				
				//Address a = new Address();
				a.setZip(Zip);
				p.setResAddr(a);
				pro.setPerInfo(p);
			
			
			session.update(pro);
			txn.commit();
			}
			catch(Exception exp)
			{
				exp.printStackTrace();
			}
			
		}
		if(ae.getSource() == b3)
		{
			try
			{
			Configuration config = new Configuration().configure();
			ServiceRegistry registry=new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			SessionFactory factory = config.buildSessionFactory(registry);
			Session session = factory.getCurrentSession();
			Transaction txn = session.beginTransaction();
			
			Profile pro = (Profile)session.get(Profile.class,ProfileId);
			f2.setText(pro.getCreationDate());
			f3.setText(pro.getEduInfo().getQualification());
			f4.setText(pro.getEduInfo().getResult());
			
			//EducationalDetails edu = new EducationalDetails(); 
			int y = pro.getEduInfo().getYearPassing();
			System.out.println("year = "+y);
			String yr = Integer.toString(y);
			f5.setText(yr);
			f6.setText(pro.getPerInfo().getBirthDate());
			f7.setText(pro.getPerInfo().getContactNo());
			f8.setText(pro.getPerInfo().getEmail());
			f9.setText(pro.getPerInfo().getFirstName());
			f10.setText(pro.getPerInfo().getGender());
			f11.setText(pro.getPerInfo().getLastName());
			f12.setText(pro.getPerInfo().getResAddr().getCity());
			f13.setText(pro.getPerInfo().getResAddr().getCountry());
			f14.setText(pro.getPerInfo().getResAddr().getStreet());
			f15.setText(pro.getPerInfo().getResAddr().getZip());
			
			txn.commit();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String []args)
	{
		
		Client cl = new Client();
		
		/*try
		{
		Configuration config = new Configuration().configure();
		ServiceRegistry registry=new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory factory = config.buildSessionFactory(registry);
		Session session = factory.getCurrentSession();
		Transaction txn = session.beginTransaction();
		
		Profile pro = new Profile();
		pro.setProfileId(101);
		Date d1 = new Date(2002,02,02);
		pro.setCreationDate(d1);
		Address a = new Address("karve road","Pune","India","444101");
		PersonalDetails p = new PersonalDetails("Vishnu","Bhagwat","123456789","vishnu@gmail.com","Male",d1,a);
		pro.setPerInfo(p);
		
		EducationalDetails e = new EducationalDetails("Btech","pass",2019);
		pro.setEduInfo(e);
		
		session.save(pro);
		
		txn.commit();
		
		}
		catch(Exception e)
		{
			System.out.println("this is si "+e);
			
		}*/
		
	}

}

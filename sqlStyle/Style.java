package sqlStyle;
import java.util.ArrayList;
import Sample.Main;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/*
	This class is used to arrange the methods used in styling the interface
	and what to do when delete, update and search
*/
public class Style {
	   BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
	   Background background = new Background(c1);
	   ArrayList<radio> choices = new ArrayList<>();
	   String answer= "";
	   
	   public void style(Button button,String labelText, String name) {
	    	choices.clear();
	        button.setOnAction(k -> {
	        	Stage stage2 = new Stage();
	            GridPane pane2 = gridPane();

	            Label hello = new Label("Conditions for "+name);
	            hello.setFont(Font.font(17));
	            hello.setTextFill(Color.GREY);
	            pane2.add(hello, 0, 0);

	            Button logo2 = logo();
	            pane2.add(logo2, 1, 0);

        		if(name == "employee")
        			employee(pane2);
        		else if( name == "manager")
        			manager(pane2);
        		else if(name == "customer")
        			customer(pane2);
        		else if(name == "account")
        			account(pane2);
        		else if(name =="loan")
        			loan(pane2);
        		else if(name =="payment")
        			payment(pane2);
        		else if(name=="card")
        			card(pane2);
        		else if(name == "transaction")
        			transaction(pane2);
    	        
        		Button run = new Button("Next");
                run.setFont(Font.font(14));
                run.setPrefSize(90, 30);
                GridPane.setHalignment(run, HPos.RIGHT);
                run.setStyle("-fx-background-radius: 10, 4;-fx-background-color:lightgrey;");
                run.setTextFill(Color.DARKSLATEBLUE);
                pane2.add(run, 2, 0);
                run.setOnAction(i->{ 
                	Stage stage3 = new Stage();
	                GridPane pane3 = gridPane();
	                
	                Label helloo= new Label("Which "+ name);
	                helloo.setFont(Font.font(17));
	                helloo.setTextFill(Color.GREY);
	                pane3.add(helloo, 0, 0);
	                
	                Label hell3oo= new Label("No conditions on " +name);
	                hell3oo.setFont(Font.font(17));
	                hell3oo.setTextFill(Color.GREY);
	                
	                Button logo = logo();
	                pane3.add(logo, 1, 0);
	                
	            	if(labelText.equals("Deletion options")) {
	                    for(int i1=0;i1<choices.size();i1++) {
	                    	if(choices.get(i1).getRadio().isSelected()) {
	    						pane3.add(choices.get(i1).getName(), 0, i1+2);
	    						pane3.add(choices.get(i1).getNameT(), 1, i1+2);
	    					}
	                    }
	            	}else {
	            		int count=0;
	                    for(int i1=0;i1<choices.size();i1++) {
	     					if(choices.get(i1).getRadio().isSelected()) {
	     						pane3.add(choices.get(i1).getName(), 0, i1+2);
	     						pane3.add(choices.get(i1).getNameT(), 1, i1+2);
	     						count++;
	     					}
	                     }
	                    if(count==0)
	                    	pane3.add(hell3oo, 1, 1);
	            	} 
	            	
	            	Button ok = new Button("Okay");
	                ok.setFont(Font.font(14));
	                ok.setPrefSize(90, 30);
	                GridPane.setHalignment(ok, HPos.RIGHT);
	                ok.setStyle("-fx-background-radius: 10, 4;-fx-background-color:lightgrey;");
	                ok.setTextFill(Color.DARKSLATEBLUE);
	                pane3.add(ok, 2, 0);
	                ok.setOnAction(e-> {
	                	Stage stage4 = new Stage();
	                    GridPane pane4 = gridPane();

	                    Label hello4 = new Label("Answer");
	                    hello4.setFont(Font.font(17));
	                    hello4.setTextFill(Color.GREY);
	                    pane4.add(hello4, 0, 0);

	                    Button logo223 = logo();
	                    pane4.add(logo223, 1, 0);
	                    
	                    ArrayList<choice> conditions = new ArrayList<>();
	                	if(labelText.equals("Deletion options")) {
		                    for(int i1=0;i1<choices.size();i1++) {
		    					if(choices.get(i1).getRadio().isSelected()) {
		    						String type = choices.get(i1).getName().getId();
		    						String value = choices.get(i1).getNameT().getText();
			
		    						choice ch = new choice(type,value);
		    						conditions.add(ch);
		    					}
		                	} 
		                    
		            		if(name == "employee")
			                	answer= Main.employeeQuery.delete(conditions);
		            		else if( name == "manager")
			                	answer= Main.managerQuery.delete(conditions);
		            		else if(name == "customer")
			                	answer= Main.customerQuery.delete(conditions);
		            		else if(name == "account")
			                	answer= Main.accountQuery.delete(conditions);
		            		else if(name =="loan")
			                	answer= Main.loanQuery.delete(conditions);
		            		else if(name =="payment")
			                	answer= Main.paymentQuery.delete(conditions);
		            		else if(name=="card")
			                	answer= Main.cardQuery.delete(conditions);
		            		else if(name == "transaction")
			                	answer= Main.transactionQuery.delete(conditions);
		                	
		                    Label hello5 = new Label(answer);
		                    hello5.setFont(Font.font(17));
		                    hello5.setTextFill(Color.GREY);
		                    pane4.add(hello5, 1, 1);
		                    
		                	for(int i1=0;i1<choices.size();i1++) {
		    					if(choices.get(i1).getRadio().isSelected()) {
		    						choices.get(i1).getRadio().setSelected(false);
		    					}
		                	}
	                	}else{
		                    for(int i1=0;i1<choices.size();i1++) {
		    					if(choices.get(i1).getRadio().isSelected()) {
		    						String type = choices.get(i1).getName().getId();
		    						String value = choices.get(i1).getNameT().getText();
			
		    						choice ch = new choice(type,value);
		    						conditions.add(ch);
		    					}
		                	}
	                		if(labelText.equals("Search options")) {
	                    		hello4.setText("What to show");
	                		}else {
	                    		hello4.setText("What to update");
	                		}
	                		
	                		if(name == "employee")
	                			employee(pane4);
	                		else if( name == "manager")
	                			manager(pane4);
	                		else if(name == "customer")
	                			customer(pane4);
	                		else if(name == "account")
	                			account(pane4);
	                		else if(name =="loan")
	                			loan(pane4);
	                		else if(name =="payment")
	                			payment(pane4);
	                		else if(name=="card")
	                			card(pane4);
	                		else if(name == "transaction")
	                			transaction(pane4);
	                		
		                	for(int i1=0;i1<choices.size();i1++) {
		    					if(choices.get(i1).getRadio().isSelected()) {
		    						choices.get(i1).getRadio().setSelected(false);
		    					}
		                	}
	                	}
	                	
	                    Button oka = new Button("Okay");
	                    oka.setFont(Font.font(14));
	                    oka.setPrefSize(90, 30);
	                    GridPane.setHalignment(oka, HPos.RIGHT);
	                    oka.setStyle("-fx-background-radius: 10, 4;-fx-background-color:lightgrey;");
	                    oka.setTextFill(Color.DARKSLATEBLUE);
	                    pane4.add(oka, 2, 0);
	                    oka.setOnAction(u->{
	                    	ArrayList<choice> conditions1 = new ArrayList<>();
	                		Stage stage5 = new Stage();
	                        GridPane pane5 = gridPane();
	                        
	                        Label hello54 = new Label();
	                        hello54.setFont(Font.font(17));
	                        hello54.setTextFill(Color.GREY);
	                        pane5.add(hello54, 0, 0);

	                        Button logo5 = logo();
	                        pane5.add(logo5, 1, 0);
	                        
	                        if(labelText.equals("Search options")){
	                        	hello54.setText("Answer");
	    	                    for(int i1=0;i1<choices.size();i1++) {
	    	    					if(choices.get(i1).getRadio().isSelected()) {
	    	    						String type = choices.get(i1).getName().getId();
	    	    						System.out.println(choices.get(i1).getName().getId());
	    	    						choice ch = new choice(type);
	    	    						conditions1.add(ch);
	    	    					}
	    	                	}
	    	                	for(int i1=0;i1<choices.size();i1++) {
	    	    					if(choices.get(i1).getRadio().isSelected()) {
	    	    						choices.get(i1).getRadio().setSelected(false);
	    	    					}
	    	                	}
	    	                	if(name == "employee")
		    	                	answer= Main.employeeQuery.search(conditions,conditions1,pane5,1,1);
	    	            		else if( name == "manager")
		    	                	answer= Main.managerQuery.search(conditions,conditions1,pane5,1,1);
	    	            		else if(name == "customer")
		    	                	answer= Main.customerQuery.search(conditions,conditions1,pane5,1,1);
	    	            		else if(name == "account")
		    	                	answer= Main.accountQuery.search(conditions,conditions1,pane5,1,1);
	    	            		else if(name =="loan")
		    	                	answer= Main.loanQuery.search(conditions,conditions1,pane5,1,1);
	    	            		else if(name =="payment")
		    	                	answer= Main.paymentQuery.search(conditions,conditions1,pane5,1,1);
	    	            		else if(name=="card")
		    	                	answer= Main.cardQuery.search(conditions,conditions1,pane5,1,1);
	    	            		else if(name == "transaction")
		    	                	answer= Main.transactionQuery.search(conditions,conditions1,pane5,1,1);
	    	            		
	    	                	Button okay5 = new Button("Okay");
                                okay5.setFont(Font.font(14));
                                okay5.setPrefSize(90, 30);
                                GridPane.setHalignment(okay5, HPos.CENTER);
                                okay5.setStyle("-fx-background-radius: 10, 4;-fx-background-color:lightgrey;");
                                okay5.setTextFill(Color.DARKSLATEBLUE);
                                
	                            if(answer.equalsIgnoreCase("Nothing was found")) {
		    	                	Label hello7 = new Label(answer);
		                            hello7.setFont(Font.font(17));
		                            hello7.setTextFill(Color.GREY);
		                            pane5.add(hello7, 1, 1);
	                                pane5.add(okay5, 2, 0);
	                                GridPane.setHalignment(hello7, HPos.CENTER);
	                            }else {
	                                pane5.add(okay5, 2, 0);
	                            }
                                okay5.setOnAction(r6->{
                                	answer="";
                                	stage5.close();
                                	stage4.close();
                                	stage3.close();
                                	stage2.close();
                                });
    	  	                    //Create Scene
                                Scene scene5 = new Scene(pane5);
                                stage5.setScene(scene5);
                                stage5.setTitle("The National Bank");
                                stage5.getIcons().add(new Image("TNB.png"));
                                stage5.show();
	                        }else if(labelText.equals("Update options") ) {
	                        	hello54.setText("Values");
	                        	for(int i1=0;i1<choices.size();i1++) {
	             					if(choices.get(i1).getRadio().isSelected()) {
	             						pane5.add(choices.get(i1).getName(), 0, i1+2);
	             						pane5.add(choices.get(i1).getNameT(), 1, i1+2);
	             					}
	                            }
	              
	                            Button okay = new Button("Okay");
	                            okay.setFont(Font.font(14));
	                            okay.setPrefSize(90, 30);
	                            GridPane.setHalignment(okay, HPos.RIGHT);
	                            okay.setStyle("-fx-background-radius: 10, 4;-fx-background-color:lightgrey;");
	                            okay.setTextFill(Color.DARKSLATEBLUE);
	                            pane5.add(okay, 2, 0);
	                            okay.setOnAction(r->{
	                            	Stage stage6 = new Stage();
                                    GridPane pane6 = gridPane();
                                    
                                    Label hello6 = new Label();
                                    hello6.setFont(Font.font(17));
                                    hello6.setTextFill(Color.GREY);
                                    pane6.add(hello6, 0, 0);

                                    Button logo6 = logo();
                                    pane6.add(logo6, 1, 0);
                                    
            	                    for(int i1=0;i1<choices.size();i1++) {
            	    					if(choices.get(i1).getRadio().isSelected()) {
            	    						String type = choices.get(i1).getName().getId();
            	    						String value = choices.get(i1).getNameT().getText();

            	    						choice ch = new choice(type,value);
            	    						System.out.println(ch);
            	    						conditions1.add(ch);
            	    					}
            	                	}
            	                	for(int i1=0;i1<choices.size();i1++) {
            	    					if(choices.get(i1).getRadio().isSelected()) {
            	    						choices.get(i1).getRadio().setSelected(false);
            	    					}
            	                	}
            	            		if(name == "employee")
	                                    answer= Main.employeeQuery.update(conditions, conditions1);
            	            		else if( name == "manager")
	                                    answer= Main.managerQuery.update(conditions, conditions1);
            	            		else if(name == "customer")
	                                    answer= Main.customerQuery.update(conditions, conditions1);
            	            		else if(name == "account")
	                                    answer= Main.accountQuery.update(conditions, conditions1);
            	            		else if(name =="loan")
	                                    answer= Main.loanQuery.update(conditions, conditions1);
            	            		else if(name =="payment")
	                                    answer= Main.paymentQuery.update(conditions, conditions1);
            	            		else if(name=="card")
	                                    answer= Main.cardQuery.update(conditions, conditions1);
            	            		else if(name == "transaction")
	                                    answer= Main.transactionQuery.update(conditions, conditions1);
                                    
            	                	Label ans = new Label(answer);
            	                	ans.setFont(Font.font(17));
            	                	ans.setTextFill(Color.GREY);
                                    pane6.add(ans, 1, 1);
                                    
                                    Button okay6 = new Button("Okay");
                                    okay6.setFont(Font.font(14));
                                    okay6.setPrefSize(90, 30);
                                    GridPane.setHalignment(okay6, HPos.RIGHT);
                                    okay6.setStyle("-fx-background-radius: 10, 4;-fx-background-color:lightgrey;");
                                    okay6.setTextFill(Color.DARKSLATEBLUE);
                                    pane6.add(okay6, 2, 0);
                                    okay6.setOnAction(r6->{
                                    	answer="";
                                    	stage6.close();
                                    	stage5.close();
                                    	stage4.close();
                                    	stage3.close();
                                    	stage2.close();
                                    });
                                	//Create Scene
                                    Scene scene6 = new Scene(pane6);
                                    stage6.setScene(scene6);
                                    stage6.setTitle("The National Bank");
                                    stage6.getIcons().add(new Image("TNB.png"));
                                    stage6.show();
	                            });
    	  	                    //Create Scene
                                Scene scene5 = new Scene(pane5);
                                stage5.setScene(scene5);
                                stage5.setTitle("The National Bank");
                                stage5.getIcons().add(new Image("TNB.png"));
                                stage5.show();
	                        }else {//delete
	                        	answer="";
	                        	stage5.close();
	                        	stage4.close();
	                        	stage3.close();
	                        	stage2.close();
	                    	}
	                    });
	                	//Create Scene
	                    Scene scene4 = new Scene(pane4);
	                    stage4.setScene(scene4);
	                    stage4.setTitle("The National Bank");
	                    stage4.getIcons().add(new Image("TNB.png"));
	                    stage4.show();
	                });
	             	//Create Scene
	                Scene scene3 = new Scene(pane3);
	                stage3.setScene(scene3);
	                stage3.setTitle("The National Bank");
	                stage3.getIcons().add(new Image("TNB.png"));
	                stage3.show();
                });
                //Create Scene
	            Scene scene2 = new Scene(pane2);
	            stage2.setScene(scene2);
	            stage2.setTitle("The National Bank");
	            stage2.getIcons().add(new Image("TNB.png"));
	            stage2.show();
	        });
	   }

	   public void employee(GridPane pane2) {
	        radio employee2 =new radio("employeeID.png",pane2,0,1,"ID:","employee_ID");
	        choices.add(0,employee2);
	        
	        radio emoloyeeName = new radio("employeeName.png",pane2,1,1,"Name:","employee_name");
	        choices.add(1,emoloyeeName);

	        radio empoyeeP = new radio("phone.png",pane2,2,1,"Phone:","employee_phone");
	        choices.add(2,empoyeeP);
	        
	        radio employG = new radio("gender.png",pane2,0,2,"Gender:","employee_gender");
	        choices.add(3,employG);

	        radio employeeD = new radio("calendar(1).png",pane2,1,2,"Date of birth:","employee_DOB");
	        choices.add(4,employeeD);

	        radio employeeE = new radio("email.png",pane2,2,2,"Email:","employee_Email");
	        choices.add(5,employeeE);

	        radio empoyeeS = new radio("pay.png",pane2,0,3,"Salary","employee_Salary");
	        choices.add(6,empoyeeS);

	        radio depID = new radio("DepartmentID.png",pane2,1,3,"Department ID:","Department_ID");
	        choices.add(7,depID);

	        radio address =new radio("address.png",pane2,2,3,"Adress:","address_ID");
	        choices.add(8,address);
	    }
	    
	   public void manager(GridPane pane2) {
	        radio employee2 = new radio("employeeID.png",pane2,0,1,"ID:","Manager_ID");
	        choices.add(0,employee2);
	        
	        radio emoloyeeName = new radio("employeeName.png",pane2,1,1,"Name:","Manage_name");
	        choices.add(1,emoloyeeName);

	        radio employG = new radio("gender.png",pane2,2,1,"Gender:","Manager_Gender");
	        choices.add(2,employG);

	        radio employeeD = new radio("calendar(1).png",pane2,0,2,"Date of birth:","Manager_BOB");
	        choices.add(3,employeeD);

	        radio employeeE = new radio("email.png",pane2,1,2,"Email:","Manage_Email");
	        choices.add(4,employeeE);

	        radio empoyeeS = new radio("pay.png",pane2,2,2,"Salary:","Manage_Salary");
	        choices.add(5,empoyeeS);

	        radio empoyeeP = new radio("phone.png",pane2,0,3,"Phone:","Manager_phone");
	        choices.add(6,empoyeeP);

	        radio address = new radio("address.png",pane2,1,3,"Adress:","address_ID");
	        choices.add(7,address);
	    }
	   
	   private void customer(GridPane pane2) {
	        radio employee2 = new radio("employeeID.png",pane2,0,1,"ID:","customer_id");
	        choices.add(0, employee2);
	        
	        radio emoloyeeName = new radio("employeeName.png",pane2,1,1,"Name:","customer_name");
	        choices.add(1, emoloyeeName);
	        
	        radio employG = new radio("gender.png",pane2,2,1,"Gender:","customer_Gender");
	        choices.add(2, employG);
	        
	        radio employeeD = new radio("calendar(1).png",pane2,0,2,"Calender:","customer_DOB");
	        choices.add(3, employeeD);
	        
	        radio empoyeeP = new radio("phone.png",pane2,1,2,"Phone:","customer_phone");
	        choices.add(4, empoyeeP);
	        
	        radio address = new radio("address.png",pane2,2,2,"Adress:","address_ID");
	        choices.add(5, address);		
		}

	   private void account(GridPane pane2) {
	        radio employee2 = new radio("employeeID.png",pane2,0,1,"Account ID:","account_id");
	        choices.add(0, employee2);
	        
	        radio emoloyeeName = new radio("customer ID.png",pane2,1,1,"Customer ID:","customer_id");
	        choices.add(1, emoloyeeName);
	        
	        radio employG = new radio("accountType.png",pane2,2,1,"Account Type:","Account_Type");
	        choices.add(2, employG);
	        
	        radio employeeD = new radio("regestrationDate.png",pane2,0,2,"REgesteration Date:","Registration_Date");
	        choices.add(3, employeeD);
	        
	        radio employeeE = new radio("activationDate.png",pane2,1,2,"Activation Date:","Activation_Date");
	        choices.add(4, employeeE);
	        
	        radio empoyeeS = new radio("branchID.png",pane2,2,2,"Barnch ID:","branch_ID");
	        choices.add(5, empoyeeS);
	        
	        radio Interest =  new radio("Interest.png",pane2,0,3,"Interest:","Interest");
	        choices.add(6, Interest);
	        
	        radio initialDeposit =  new radio("initial_deposity.png",pane2,1,3,"Initial Deposity:","initial_deposity");
	        choices.add(7, initialDeposit);		
		}
	    
	   private void loan(GridPane pane2) {
	        radio loanNumber =  new radio("loanNumber.png",pane2,0,1,"Loan number:","Loan_number");
	        choices.add(0, loanNumber);
	        
	        radio id = new radio("branchID.png",pane2,1,1,"Branch ID:","Branch_ID");
	        choices.add(1, id);
	        
	        radio customeri = new radio("customer ID.png",pane2,2,1,"Customer ID:","customer_id");
	        choices.add(2, customeri);
	        
	        radio loanAmoun = new radio("loanAmount.png",pane2,0,2,"Loan Amount:","Loan_amount");
	        choices.add(3, loanAmoun);
	        
	        radio loanTyp = new radio("loanType.png",pane2,1,2,"Loan Type:","Loan_type");
	        choices.add(4, loanTyp);
	        
	        radio dateL = new radio("loanDate.png",pane2,2,2,"Loan Date:","loan_date");
	        choices.add(5, dateL);		
		}

	   private void payment(GridPane pane2) {
	        radio loanNumber = new radio("employeeID.png",pane2,0,1,"ID:","Payment_Number");
	        choices.add(0, loanNumber);
	        
	        radio id = new radio("loanNumber.png",pane2,1,1,"Loan number:","Loan_number");
	        choices.add(1, id);
	        
	        radio customeri = new radio("paymnetAmount.png",pane2,1,2,"Payment Amount:","Payment_amount");
	        choices.add(2, customeri);
	        
	        radio loanTyp = new radio("paymentDate.png",pane2,2,1,"Payment Date:","Payment_date");
	        choices.add(3, loanTyp);		
		}

	   private void card(GridPane pane2) {
	        radio id = new radio("cardID.png",pane2,0,1,"ID:","card_ID");
	        choices.add(0, id);
	        
	        radio customeri = new radio("cardLimit.png",pane2,0,2,"Card Limit:","card_limit");
	        choices.add(1, customeri);
	        
	        radio loanAmoun = new radio("cardExpDate.png",pane2,2,1,"Card Expiration Date:","card_exp_date");
	        choices.add(2, loanAmoun);
	        
	        radio loanTyp = new radio("customer ID.png",pane2,1,1,"Customer ID:","customer_id");
	        choices.add(3, loanTyp);		
		}

	   private void transaction(GridPane pane2) {
	        radio id = new radio("transactionId.png",pane2,0,1,"ID:","Transaction_ID");
	        choices.add(0, id);
	        
	        radio customeri = new radio("customer ID.png",pane2,1,1,"Customer ID:","customer_id");
	        choices.add(1, customeri);
	        
	        radio loanAmoun = new radio("empID.png",pane2,2,1,"Employee ID:","employee_ID");
	        choices.add(2, loanAmoun);
	        
	        radio loanTyp = new radio("TranspositionDate.png",pane2,0,2,"Transaction Date:","Transposition_date");
	        choices.add(3, loanTyp);
	        
	        radio dateL = new radio("Transpositiontype.png",pane2,1,2,"Transaction Type:","Transposition_type");
	        choices.add(4, dateL);
	        
	        radio transactionAmoun = new radio("transactionAmount.png",pane2,2,2,"Transaction Amount:","Transposition_amount");
	        choices.add(5, transactionAmoun);		
		}

	   public GridPane gridPane(){
	        GridPane pane2 = new GridPane();
	        pane2.setPadding(new Insets(60, 60, 60, 60));
	        pane2.setAlignment(Pos.CENTER);
	        pane2.setHgap(10);
	        pane2.setVgap(10);
	        pane2.setBackground(background);
	        return pane2;
	    }

	   public Button logo() {
	        Image img9 = new Image("TNB.png");
	        ImageView v10 = new ImageView(img9);
	        v10.setFitWidth(150);
	        v10.setFitHeight(70);

	        Button logo2 = new Button();
	        GridPane.setHalignment(logo2, HPos.CENTER);
	        logo2.setPrefSize(180, 100);
	        logo2.setGraphic(v10);
	        logo2.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
	        return logo2;
	    }
	    
	   public Button bigButton(String url) {
	        Image img = new Image(url);
	        ImageView v5 = new ImageView(img);
	        v5.setFitWidth(190);
	        v5.setFitHeight(190);

	        Button view = new Button();
	        view.setTextFill(Color.BROWN);
	        view.setPrefSize(200, 200);
	        view.setGraphic(v5);
	        view.setStyle("-fx-background-radius: 7;-fx-background-color:lightblue;");
	        return view;
	    }
	    
	   public Button midButton(String url){
	        Image img = new Image(url);
	        ImageView v1 = new ImageView(img);
	        v1.setFitWidth(170);
	        v1.setFitHeight(170);

	        Button button = new Button();
	        button.setTextFill(Color.BROWN);
	        button.setPrefSize(180, 180);
	        button.setGraphic(v1);
	        button.setStyle("-fx-background-radius: 7;-fx-background-color:lightblue;");
	        return button;
		}

	   public Button litButton(String url){
	        Button add = new Button(url);
	        add.setFont(Font.font(14));
	        add.setPrefSize(90, 30);
	        add.setStyle("-fx-background-radius: 10, 4;-fx-background-color:lightgrey;");
	        add.setTextFill(Color.DARKSLATEBLUE);
	        return add;
	   }
}

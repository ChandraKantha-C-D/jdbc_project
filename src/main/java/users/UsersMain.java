package users;
import java.util.Scanner;

public class UsersMain {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		boolean repeat = true;
		Users users = new Users();
		UsersCRUD crud = new UsersCRUD();

		do {
			System.out.println("Press 1. to signup");
			System.out.println("Press 2. to login");
			System.out.println("Press 3. to exit");
			System.out.println("Enter your choice");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1: {
				System.out.println("Enter the user id");
				int id = scanner.nextInt();
				System.out.println("Enter the user name");
				String username = scanner.next();
				System.out.println("Enter the email");
				String email = scanner.next();
				System.out.println("Enter the password");
				String password = scanner.next();
				

				users.setId(id);
				users.setUsername(username);
				users.setEmail(email);
				users.setPassword(password);
				

				crud.signUpUser(users);
			}
				break;

			case 2: {
				System.out.println("Enter the EMAIL");
				String email = scanner.next();
				System.out.println("Enter the password");
				String password = scanner.next();

				users.setEmail(email);
				users.setPassword(password);

				boolean result = crud.loginUser(users);
				if (result == true) {
					System.out.println("Logged in successfully");
					boolean flag=true;
					do{
					System.out.println("Press 1 : Facebook");
					System.out.println("Press 2 : Instagram");
					System.out.println("Press 3 : Snapchat");
					System.out.println("Press 4 : Whatsapp");
					System.out.println("Press 5 : Twitter");
					System.out.println("Press 6 : To Exit");
					System.out.println("Enter your choice");
					int loginchoice = scanner.nextInt();
					switch (loginchoice) {
					case 1: {
						System.out.println("Press 1: to display password");
						System.out.println("Press 2: to reset password");
						System.out.println("Enter your choice");
						int newchoice = scanner.nextInt();
						switch (newchoice) {
						case 1: {
							crud.facebook(email);
						}
							break;
						case 2: {
							System.out.println("Enter the password to be reset");
							String resetpassword = scanner.next();
						    int save = crud.signupFacebook(email, resetpassword);
							if (save == 1)
								System.out.println("password reseted successfully");
							else
								System.out.println("password not reseted");
						}
							break;

						default:
							System.out.println("Invalid choice");
						}
					}

					case 2: {
						System.out.println("Press 1: to EXIT");
						System.out.println("Press 2: to reset password");
						System.out.println("Press 3: to diplay");
						System.out.println("Enter your choice");
						int newchoice = scanner.nextInt();
						switch (newchoice) {
						case 1: {
							flag=false;
						}
							break;
						case 2: {
							System.out.println("Enter the password to be reset");
							String resetpassword = scanner.next();
							int save = crud.signupInsta(email, resetpassword);
							if (save == 1)
								System.out.println("password reseted successfully");
							else
								System.out.println("password not reseted");
						}
							break;
							
						case 3:{
							crud.instagram(email);
							}break;

						default:
							System.out.println("Invalid choice");
						}
					}
						
					case 3: {
						System.out.println("Press 1: to EXIT");
						System.out.println("Press 2: to reset password");
						System.out.println("Press 3: to diplay");
						System.out.println("Enter your choice");
						int newchoice = scanner.nextInt();
						switch (newchoice) {
						case 1: {
							flag=false;
						}
							break;
						case 2: {
							System.out.println("Enter the password to be reset");
							String resetpassword = scanner.next();
							int save = crud.signupSnapChat(email, resetpassword);
							if (save == 1)
								System.out.println("password reseted successfully");
							else
								System.out.println("password not reseted");
						}
							break;
						case 3:{
							crud.snapchat(email);
						}	

						default:
							System.out.println("Invalid choice");
						}

					}
						break;

					case 4: {
						System.out.println("Press 1: to EXIT");
						System.out.println("Press 2: to reset password");
						System.out.println("Press 3: to diplay");
						System.out.println("Enter your choice");
						int newchoice = scanner.nextInt();
						switch (newchoice) {
						case 1: {
							flag=false;
						}
							break;
						case 2: {
							System.out.println("Enter the password to be reset");
							String resetpassword = scanner.next();
							int save = crud.signupWhatsap(email, resetpassword);
							if (save == 1)
								System.out.println("password reseted successfully");
							else
								System.out.println("password not reseted");
						}
							break;
						case 3:{
							crud.whatsap(email);
						}		

						default:
							System.out.println("Invalid choice");
						}
					}
						break;

					case 5: {
						System.out.println("Press 1: to EXIT");
						System.out.println("Press 2: to reset password");
						System.out.println("Press 3: to diplay");
						System.out.println("Enter your choice");
						int newchoice = scanner.nextInt();
						switch (newchoice) {
						case 1: {
							flag=false;
						}
							break;
						case 2: {
							System.out.println("Enter the password to be reset");
							String resetpassword = scanner.next();
							int save = crud.signupTwitter(email, resetpassword);
							if (save == 1)
								System.out.println("password reseted successfully");
							else
								System.out.println("password not reseted");
						}
							break;
						case 3:{
							crud.twitter(email);
						}		

						default:
							System.out.println("Invalid choice");
						}

					}
						break;
					case 6:
						flag=false;
						System.out.println("Logged out successfully");
						break;
					}
				
				}
				while(flag);
				}else
					System.out.println("Invalid password");

			}
				break;
			case 3: {
				repeat = false;
				System.out.println("Thank You");
			}

			}

		} while (repeat);

	}
}


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class ClubDepartment {

    // Defining Attributes --------------------------------------------
    public int idClubDepartment;
    public String departmentName;
    public ClubMember manager;
    public ArrayList<ClubMember> coManagers;
    public String responsibilityDescription;


    // Making the constructor with default values ------------------------------
    public ClubDepartment(){
        this.idClubDepartment = -1;
        this.departmentName = "";
        this.manager = null;
        this.coManagers = new ArrayList<>();
        this.responsibilityDescription = "";
    }

    public static ClubDepartment createDepartment(ArrayList<ClubMember> members){
        Scanner input = new Scanner(System.in);
        ClubDepartment department = new ClubDepartment();

        System.out.println("\n[*] Note: keep in mind that you can keep it empty and it will take the default value ");
        System.out.print("[-] Enter department ID (Obligation): ");
        department.idClubDepartment = input.nextInt();
        input.nextLine();
        System.out.print("[-] Enter department name: ");
        department.departmentName = input.nextLine();
        System.out.print("[-] Enter department manager ID: ");

        // Here it will take the id and search in the members list, then it will change it information
        int id = input.nextInt();
        for(ClubMember member : members){
            if(member.idPerson == id){
                member.lastRejoinDate = LocalDateTime.now();
                department.manager = member;
                break;
            }
        }if(department.manager == null){
            System.out.println("\n[!] Couldn't find member with that id!\n[!] The manager will stays empty, you can fill it in the update department\n");
        }

        System.out.print("[-] Enter how much members you want to fill: ");

        //Here it will ask the user for each id of the member who will join the club, if it didn't find that member it will show a message that some members wasn't found and that he can change it in the update function
        int x = input.nextInt();
        for(int i=0;i<x;i++){
            System.out.printf("[%d] Enter %d member ID: ", i+1, i+1);
            int id_member = input.nextInt();
            for(ClubMember member : members){
                if(member.idPerson == id_member){
                    member.lastRejoinDate = LocalDateTime.now();
                    department.coManagers.add(member);
                    break;
                }
            }
        }if(department.coManagers.size() < x){
            System.out.println("\n[!] Couldn't find some members!\n[!] You can try refill it in the update department\n");
        }

        input.nextLine();
        System.out.print("[-] Enter department responsibility description: ");
        department.responsibilityDescription = input.nextLine();

        // Here will also update the members information
        for(ClubMember member : department.coManagers){
            member.clubDepartment = department;
        }
        department.manager.clubDepartment = department;

        return department;
    }

    // Printing the department information -------------------------------------------------
    public void showInfo(){
        System.out.println("\n[-] Department ID: " + this.idClubDepartment);
        System.out.println("[-] Department name: " + this.departmentName);
        System.out.println("[-] Department manager name and ID: " + this.manager.name + " " + this.manager.midName + " " + this.manager.firstName + " | ID: " + this.manager.idPerson);
        System.out.printf("[-] %d Members associated with that department:\n", this.coManagers.size());
        for(ClubMember member : this.coManagers){
            System.out.printf("[*] Member name: %s %s %s | ID: %d\n", member.name, member.midName, member.firstName, member.idPerson);
        }

        System.out.println("[-] Department responsibility description: " + this.responsibilityDescription);
    }


    // Updating information of the department ------------------------------------------------------------------------------
    public void updateInfo(ArrayList<ClubMember> members){
        Scanner input = new Scanner(System.in);

        // Here it will clear the last information of the members and the manager and make it null
        for(ClubMember member : this.coManagers){
            member.clubDepartment = null;
        }
        this.coManagers.clear();
        this.manager.clubDepartment = null;
        this.manager = null;

        System.out.println("\n[*] Note: keep in mind that you can keep it empty and it will take the default value ");
        System.out.print("[-] Enter department new ID (Obligation): ");
        this.idClubDepartment = input.nextInt();
        input.nextLine();
        System.out.print("[-] Enter department new name: ");
        this.departmentName = input.nextLine();
        System.out.print("[-] Enter department new manager ID: ");

        // Same as the create function ----------------------------------------------
        int id = input.nextInt();
        for(ClubMember member : members){
            if(member.idPerson == id){
                member.lastRejoinDate = LocalDateTime.now();
                this.manager = member;
                break;
            }
        }if(this.manager == null){
            System.out.println("\n[!] Couldn't find member with that id!\n[!] The manager will stays empty, you can fill it in the update department\n");
        }

        System.out.print("[-] Enter how much members you want to fill: ");
        int x = input.nextInt();
        for(int i=0;i<x;i++){
            System.out.printf("[%d] Enter %d member ID: ", i+1, i+1);
            int id_member = input.nextInt();
            for(ClubMember member : members){
                if(member.idPerson == id_member){
                    member.lastRejoinDate = LocalDateTime.now();
                    this.coManagers.add(member);
                    break;
                }
            }
        }if(this.coManagers.size() < x){
            System.out.println("\n[!] Couldn't find some members!\n[!] You can try refill it in the update department\n");
        }

        input.nextLine();
        System.out.print("[-] Enter department new responsibility description: ");
        this.responsibilityDescription = input.nextLine();


        for(ClubMember member : this.coManagers){
            member.clubDepartment = this;
        }
        this.manager.clubDepartment = this;

    }

    // Deleting a department ------------------------------------------------------------------------
    public static int deleteDepartment(ArrayList<ClubDepartment> departments, int id){
        for(int i=0;i<departments.size();i++){
            if(departments.get(i).idClubDepartment == id){
                for(ClubMember member : departments.get(i).coManagers){         // Here it will change the members information then the department will be deleted
                    member.clubDepartment = null;
                }
                departments.get(i).manager.clubDepartment = null;
                departments.remove(i);
                return 1;
            }
        }
        return -1;
    }

}

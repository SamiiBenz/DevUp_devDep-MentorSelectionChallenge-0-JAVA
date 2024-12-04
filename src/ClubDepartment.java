import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
        int id = input.nextInt();
        for(ClubMember member : members){
            if(member.idPerson == id){
                if(member.firstJoinDate == null){
                    member.firstJoinDate = LocalDateTime.now();
                }
                member.lastRejoinDate = LocalDateTime.now();
                department.manager = member;
                break;
            }
        }if(department.manager == null){
            System.out.println("\n[!] Couldn't find member with that id!\n[!] The manager will stays empty, you can fill it in the update department\n");
        }

        System.out.print("[-] Enter how much members you want to fill: ");
        int x = input.nextInt();
        for(int i=0;i<x;i++){
            System.out.printf("[%d] Enter %d member ID: ", i+1, i+1);
            int id_member = input.nextInt();
            for(ClubMember member : members){
                if(member.idPerson == id_member){
                    if(member.firstJoinDate == null){
                        member.firstJoinDate = LocalDateTime.now();
                    }
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


        return department;
    }

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

}

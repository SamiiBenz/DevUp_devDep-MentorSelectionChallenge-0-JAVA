import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Defining a scanner var to take inputs from the user ------------------------
        Scanner input = new Scanner(System.in);

        ArrayList<ClubMember> existingMembers = new ArrayList<>();
        ArrayList<ClubDepartment> existingDepartments = new ArrayList<>();
        int running = 1;


        System.out.println("\n[*] Managing Club Members");

        while(running == 1) {
            System.out.print("\n[?] Which operation you want to use?:-----------------------------------------------\n\n" +
                    "[CM] Create a Member\n" +
                    "[CD] Create a Department\n" +
                    "[VM] View Members\n" +
                    "[VD] View Departments\n" +
                    "[UM] Update a Member\n" +
                    "[UD] Update a Department\n" +
                    "[DM] Delete a Member\n" +
                    "[DD] Delete a Department\n" +
                    "[E] Exit\n");
            System.out.print("\n[-] Enter your action: ");
            String x = input.next();

            switch (x) {
                case "CM":
                    existingMembers.add(ClubMember.createMemeber());
                    break;

                case "CD":
                    existingDepartments.add(ClubDepartment.createDepartment(existingMembers));
                    break;

                case "VM":
                    for(ClubMember existingMember : existingMembers){
                        existingMember.showInfo();
                    }
                    break;

                case "VD":
                    for(ClubDepartment existingDepartment : existingDepartments){
                        existingDepartment.showInfo();
                    }
                    break;

                case "UM":
                    System.out.print("[-] Enter member ID to update it information: ");
                    int id_update = input.nextInt();
                    int found = 0;
                    for(ClubMember existingMember : existingMembers){
                        if(existingMember.idPerson == id_update){
                            existingMember.updateInfo();
                            found = 1;
                            break;
                        }
                    }
                    if(found == 0){System.out.println("\n[!] Couldn't find Member with entered ID!");}
                    break;

                case "UD":
                    System.out.print("[-] Enter department ID to update it information: ");
                    int id_department_update = input.nextInt();
                    int found_it = 0;
                    for(ClubDepartment existingDepartment : existingDepartments){
                        if(existingDepartment.idClubDepartment == id_department_update){
                            existingDepartment.updateInfo(existingMembers);
                            found_it = 1;
                            break;
                        }
                    }
                    if(found_it == 0){System.out.println("\n[!] Couldn't find Member with entered ID!");}
                    break;

                case "DM":
                    System.out.print("\n[-] Enter member ID to delete it: ");
                    int id_delete = input.nextInt();
                    if(ClubMember.deleteMember(existingMembers, id_delete)==1){
                        System.out.println("\n[+] Member has been deleted successfully!");
                    }else{
                        System.out.println("\n[!] Couldn't find Member with entered ID!");
                    }
                    break;

                case "DD":
                    System.out.print("\n[-] Enter department ID to delete it: ");
                    int id_department_delete = input.nextInt();
                    if(ClubDepartment.deleteDepartment(existingDepartments, id_department_delete)==1){
                        System.out.println("\n[+] Department has been deleted successfully!");
                    }else{
                        System.out.println("\n[!] Couldn't find Department with entered ID!");
                    }
                    break;

                case "E":
                    running = 0;
                    break;

                default:
                    System.out.println("\n[!] No such operation!");
                    break;
            }
        }
    }
}
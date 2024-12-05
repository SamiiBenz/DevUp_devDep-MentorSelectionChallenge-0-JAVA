import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class ClubMember {

    // Defining Attributes --------------------------------------------
    public int idPerson;
    public String name;
    public String midName;
    public String firstName;
    public LocalDate birthDate;
    public String birthLocation;
    public LocalDateTime firstJoinDate;
    public LocalDateTime lastRejoinDate;
    public ClubDepartment clubDepartment;
    public String university;
    public String speciality;
    public String studyLevel;
    public String bio;
    //public Bitmap profileImage;


    // Making the constructor with default values -----------------------------------------------
    public ClubMember(){
        this.idPerson = -1;
        this.name = "";
        this.midName = "";
        this.firstName ="";
        this.birthDate = null;
        this.birthLocation = "";
        this.firstJoinDate = null;
        this.lastRejoinDate = null;
        this.clubDepartment = null;
        this.university = "";
        this.speciality = "";
        this.studyLevel = "";
        this.bio = "";
        //this.profileImage = null;
    }


    public static ClubMember createMemeber(){
        Scanner input = new Scanner(System.in);
        ClubMember member = new ClubMember();

        System.out.println("\n[*] Note: keep in mind that you can keep it empty and it will take the default value ");
        System.out.print("[-] Enter member ID (Obligation): ");
        member.idPerson = input.nextInt();
        input.nextLine();
        System.out.print("[-] Enter member last name: ");
        member.name = input.nextLine();
        System.out.print("[-] Enter member middle name: ");
        member.midName = input.nextLine();
        System.out.print("[-] Enter member first name: ");
        member.firstName = input.nextLine();
        System.out.print("[-] Enter member birthdate (YYYY-MM-DD): ");
        String BirthDate = input.nextLine(); if(!BirthDate.isEmpty()){member.birthDate = LocalDate.parse(BirthDate);}
        member.firstJoinDate = LocalDateTime.now();
        System.out.print("[-] Enter member birth location: ");
        member.birthLocation = input.nextLine();
        System.out.print("[-] Enter member university: ");
        member.university = input.nextLine();
        System.out.print("[-] Enter member speciality: ");
        member.speciality = input.nextLine();
        System.out.print("[-] Enter member study level: ");
        member.studyLevel = input.nextLine();
        System.out.print("[-] Enter member bio: ");
        member.bio = input.nextLine();
        //System.out.print("[-] Enter: ");
        //member.profileImage = input.;

        return member;
    }

    public void showInfo(){
        System.out.println("\n[-] Member ID: " + this.idPerson);
        System.out.println("[-] Member last name: " + this.name);
        System.out.println("[-] Member middle name: " + this.midName);
        System.out.println("[-] Member first name: " + this.firstName);
        System.out.println("[-] Member birthdate (YYYY-MM-DD): " + this.birthDate);
        System.out.println("[-] Member birth location: " + this.birthLocation);
        System.out.println("[-] Member first join date (YYYY-MM-DD): " + this.firstJoinDate);
        System.out.println("[-] Member last rejoin date (YYYY-MM-DD): " + this.lastRejoinDate);
        if(this.clubDepartment!=null){
            System.out.println("[-] Member club department: " + this.clubDepartment.departmentName);
        }else{
            System.out.println("[-] Member club department: " + this.clubDepartment);
        }
        System.out.println("[-] Member university: " + this.university);
        System.out.println("[-] Member speciality: " + this.speciality);
        System.out.println("[-] Member study level: " + this.studyLevel);
        System.out.println("[-] Member bio: " + this.bio);
        //System.out.println("[-] Enter: ");
        //member.profileImage = input.;
    }

    public void updateInfo(){
        Scanner input = new Scanner(System.in);

        System.out.println("\n[*] Note: keep in mind that you can keep it empty and it will take the default value ");
        System.out.print("[-] Enter member new ID (Obligation): ");
        this.idPerson = input.nextInt();
        input.nextLine();
        System.out.print("[-] Enter member new last name: ");
        String Name = input.nextLine(); if(!Name.isEmpty()){this.name = Name;}
        System.out.print("[-] Enter member new middle name: ");
        String MidName = input.nextLine(); if(!MidName.isEmpty()){this.midName = MidName;}
        System.out.print("[-] Enter member new first name: ");
        String FirstName = input.nextLine(); if(!FirstName.isEmpty()){this.firstName = FirstName;}
        System.out.print("[-] Enter member new birthdate (YYYY-MM-DD): ");
        String BirthDate = input.nextLine(); if(!BirthDate.isEmpty()){this.birthDate = LocalDate.parse(BirthDate);}
        System.out.print("[-] Enter member new birth location: ");
        String BirthLocation = input.nextLine(); if(!BirthLocation.isEmpty()){this.birthLocation = BirthLocation;}
        System.out.print("[-] Enter member new university: ");
        String University = input.nextLine(); if(!University.isEmpty()){this.university = University;}
        System.out.print("[-] Enter member new speciality: ");
        String Speciality = input.nextLine(); if(!Speciality.isEmpty()){this.speciality = Speciality;}
        System.out.print("[-] Enter member new study level: ");
        String StudyLevel = input.nextLine(); if(!StudyLevel.isEmpty()){this.studyLevel = StudyLevel;}
        System.out.print("[-] Enter member new bio: ");
        String Bio = input.nextLine(); if(!Bio.isEmpty()){this.bio = Bio;}
        //System.out.print("[-] Enter: ");
        //member.profileImage = input.;

        System.out.print("\n[+] Member information has been updated successfully");
    }


    public static int deleteMember(ArrayList<ClubMember> members, int id){
        for(int i=0;i<members.size();i++){
            if(members.get(i).idPerson == id){
                members.remove(i);
                return 1;
            }
        }
        return -1;
    }

}

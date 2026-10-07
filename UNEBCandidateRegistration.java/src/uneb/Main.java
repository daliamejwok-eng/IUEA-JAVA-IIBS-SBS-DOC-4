package uneb;

/**
 * Program: UNEB Candidate Registration System
 * Course Code: BIT2115
 * Description: Demonstrates execution order of Static Blocks (SBs),
 *              Instance Initialization Blocks (IIBs), and Constructors.
 */
class Main {

    // --- STATIC FIELDS (App-wide Configuration) ---
    public static int examYear;
    public static double registrationFee;
    public static String gradingPolicy;

    // --- INSTANCE FIELDS (Per-Candidate Data) ---
    private String candidateName;
    private String schoolName;
    private String registrationStatus;
    private String examCentreCode;

    // 1. STATIC INITIALIZATION BLOCK (Executes ONCE when class is loaded)
    static {
        System.out.println("\n==================================================");
        System.out.println("[STATIC BLOCK EXECUTED] Loading UNEB System Configurations...");
        examYear = 2026;
        registrationFee = 150000.0;
        gradingPolicy = "UNEB Standard Grading Criteria (A-F)";
        System.out.println("  -> Exam Year: " + examYear);
        System.out.println("  -> Registration Fee: UGX " + registrationFee);
        System.out.println("  -> Grading Policy: " + gradingPolicy);
        System.out.println("==================================================\n");
    }

    // 2. INSTANCE INITIALIZATION BLOCK (Executes EVERY TIME an object is created)
    {
        System.out.println("[IIB EXECUTED] Initializing candidate default parameters...");
        this.registrationStatus = "PENDING_VERIFICATION";
        this.examCentreCode = "CENTRE-U0001";
        System.out.println("  -> Default Status set to: " + this.registrationStatus);
        System.out.println("  -> Default Exam Centre set to: " + this.examCentreCode);
    }

    // 3. CONSTRUCTOR (Executes AFTER IIB during object instantiation)
    public Main(String candidateName, String schoolName) {
        System.out.println("[CONSTRUCTOR EXECUTED] Finalizing registration for: " + candidateName);
        this.candidateName = candidateName;
        this.schoolName = schoolName;
        this.registrationStatus = "REGISTERED_CONFIRMED";
        System.out.println("  -> Registration Complete: " + this.candidateName + " (" + this.schoolName + ")");
        System.out.println("--------------------------------------------------");
    }

    // Display method
    public void displayCandidateInfo() {
        System.out.println("Candidate Details: " + candidateName + " | School: " + schoolName +
                " | Status: " + registrationStatus + " | Centre: " + examCentreCode);
    }

    public static void main(String[] args) {
        System.out.println(">>> MAIN METHOD STARTED <<<");

        // Instantiating Student 1
        System.out.println("\n--- Creating Student Object 1 ---");
        uneb.Main student1 = new uneb.Main("Lucia Odhong", "Gayaza High School");

        // Instantiating Student 2
        System.out.println("\n--- Creating Student Object 2 ---");
        uneb.Main student2 = new uneb.Main("John Kito", "Mengo Senior School");

        System.out.println("\n>>> REGISTRATION SUMMARY <<<");
        student1.displayCandidateInfo();
        student2.displayCandidateInfo();
    }
}
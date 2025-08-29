package Ejercicios;

interface Education {
    String details();
}

interface Experience {
    String details();
}

interface Skills {
    String details();
}

interface Certifications {
    String details();
}


class StudentEducation implements Education {
    public String details() { return "Ingeniería en Software - Itsqmet"; }
}

class StudentExperience implements Experience {
    public String details() { return "Pasantías en empresa de análisis de datos"; }
}

class StudentSkills implements Skills {
    public String details() { return "Python, SQL"; }
}

class StudentCertifications implements Certifications {
    public String details() { return "Curso de Machine Learning"; }
}


class ProfessionalEducation implements Education {
    public String details() { return "Ingeniería en Software - Itsqmet"; }
}

class ProfessionalExperience implements Experience {
    public String details() { return "5 años como desarrollador en BMI"; }
}

class ProfessionalSkills implements Skills {
    public String details() { return "Python, Java, SQL, Gestión de Proyectos"; }
}

class ProfessionalCertifications implements Certifications {
    public String details() { return "AWS Certified Solutions Architect"; }
}


interface CVFactory {
    Education createEducation();
    Experience createExperience();
    Skills createSkills();
    Certifications createCertifications();
}


class StudentCVFactory implements CVFactory {
    public Education createEducation() { return new StudentEducation(); }
    public Experience createExperience() { return new StudentExperience(); }
    public Skills createSkills() { return new StudentSkills(); }
    public Certifications createCertifications() { return new StudentCertifications(); }
}

class ProfessionalCVFactory implements CVFactory {
    public Education createEducation() { return new ProfessionalEducation(); }
    public Experience createExperience() { return new ProfessionalExperience(); }
    public Skills createSkills() { return new ProfessionalSkills(); }
    public Certifications createCertifications() { return new ProfessionalCertifications(); }
}


class CV {
    private String name;
    private Education education;
    private Experience experience;
    private Skills skills;
    private Certifications certifications;

    public CV(CVFactory factory, String name) {
        this.name = name;
        this.education = factory.createEducation();
        this.experience = factory.createExperience();
        this.skills = factory.createSkills();
        this.certifications = factory.createCertifications();
    }

    public void showCV() {
        System.out.println("CV de " + name);
        System.out.println("Educación: " + education.details());
        System.out.println("Experiencia: " + experience.details());
        System.out.println("Habilidades: " + skills.details());
        System.out.println("Certificaciones: " + certifications.details());
    }
}


public class Abstract_factory {
    public static void main(String[] args) {
        String cvType = "Student"; 
        CVFactory factory;

        if (cvType.equals("Student")) {
            factory = new StudentCVFactory();
        } else {
            factory = new ProfessionalCVFactory();
        }

        CV cv = new CV(factory, "Gabriel Proaño");
        cv.showCV();
    }
}


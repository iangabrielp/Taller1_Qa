from abc import ABC, abstractmethod


class Education(ABC):
    @abstractmethod
    def details(self):
        pass

class Experience(ABC):
    @abstractmethod
    def details(self):
        pass

class Skills(ABC):
    @abstractmethod
    def details(self):
        pass

class Certifications(ABC):
    @abstractmethod
    def details(self):
        pass

class StudentEducation(Education):
    def details(self):
        return "Ingeniería en Software - Itsqmet"

class StudentExperience(Experience):
    def details(self):
        return "Pasantías en empresa de análisis de datos"

class StudentSkills(Skills):
    def details(self):
        return "Python, SQL"

class StudentCertifications(Certifications):
    def details(self):
        return "Curso de Machine Learning"


class ProfessionalEducation(Education):
    def details(self):
        return "Ingeniería en Software - Itsqmet"

class ProfessionalExperience(Experience):
    def details(self):
        return "5 años como desarrollador en BMI"

class ProfessionalSkills(Skills):
    def details(self):
        return "Python, Java, SQL, Gestión de Proyectos"

class ProfessionalCertifications(Certifications):
    def details(self):
        return "AWS Certified Solutions Architect"


class CVFactory(ABC):
    @abstractmethod
    def create_education(self):
        pass

    @abstractmethod
    def create_experience(self):
        pass

    @abstractmethod
    def create_skills(self):
        pass

    @abstractmethod
    def create_certifications(self):
        pass


class StudentCVFactory(CVFactory):
    def create_education(self):
        return StudentEducation()

    def create_experience(self):
        return StudentExperience()

    def create_skills(self):
        return StudentSkills()

    def create_certifications(self):
        return StudentCertifications()

class ProfessionalCVFactory(CVFactory):
    def create_education(self):
        return ProfessionalEducation()

    def create_experience(self):
        return ProfessionalExperience()

    def create_skills(self):
        return ProfessionalSkills()

    def create_certifications(self):
        return ProfessionalCertifications()


class CV:
    def __init__(self, factory: CVFactory, name: str):
        self.name = name
        self.education = factory.create_education()
        self.experience = factory.create_experience()
        self.skills = factory.create_skills()
        self.certifications = factory.create_certifications()

    def show_cv(self):
        print(f"📄 CV de {self.name}")
        print("Educación:", self.education.details())
        print("Experiencia:", self.experience.details())
        print("Habilidades:", self.skills.details())
        print("Certificaciones:", self.certifications.details())


cv_type = "Student"  

if cv_type == "Student":
    factory = StudentCVFactory()
else:
    factory = ProfessionalCVFactory()

cv = CV(factory, "Gabriel Proaño")
cv.show_cv()

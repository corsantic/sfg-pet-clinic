package enemo.springframework.sfgpetclinic.bootstrap;

import enemo.springframework.sfgpetclinic.model.*;
import enemo.springframework.sfgpetclinic.services.OwnerService;
import enemo.springframework.sfgpetclinic.services.PetTypeService;
import enemo.springframework.sfgpetclinic.services.SpecialityService;
import enemo.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }


    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0 ) {
            loadData();
        }


    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");

        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");

        PetType savedCatType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);
        Speciality surgery= new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);
        Speciality dentistry= new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Micheal");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("132131232131");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);


        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 Iznik");
        owner2.setCity("Bursa");
        owner2.setTelephone("1231212");
        Pet fionasCat = new Pet();
        fionasCat.setPetType(savedCatType);
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setName("Pinky");

        owner2.getPets().add(fionasCat);
        ownerService.save(owner2);


        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Walter");
        vet1.setLastName("White");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);


        Vet vet2 = new Vet();
        vet2.setFirstName("Jesse");
        vet2.setLastName("Pinkman");
        vet2.getSpecialities().add(savedSurgery);


        vetService.save(vet2);

        System.out.println("Loaded Vets.... ");
    }
}

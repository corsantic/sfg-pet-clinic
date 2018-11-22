package enemo.springframework.sfgpetclinic.bootstrap;

import enemo.springframework.sfgpetclinic.model.Owner;
import enemo.springframework.sfgpetclinic.model.PetType;
import enemo.springframework.sfgpetclinic.model.Vet;
import enemo.springframework.sfgpetclinic.services.OwnerService;
import enemo.springframework.sfgpetclinic.services.PetTypeService;
import enemo.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }



    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");

        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");

        PetType savedCatType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Micheal");
        owner1.setLastName("Weston");

        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1= new Vet();
        vet1.setFirstName("Walter");
        vet1.setLastName("White");

        vetService.save(vet1);


        Vet vet2= new Vet();
        vet2.setFirstName("Jesse");
        vet2.setLastName("Pinkman");

        vetService.save(vet2);

        System.out.println("Loaded Vets.... ");




    }
}

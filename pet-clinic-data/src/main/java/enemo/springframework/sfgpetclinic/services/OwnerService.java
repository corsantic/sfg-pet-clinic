package enemo.springframework.sfgpetclinic.services;

import enemo.springframework.sfgpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner,Long>{

   Owner findByLastName(String lastName);


}

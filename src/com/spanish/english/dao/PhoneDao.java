package com.spanish.english.dao;

import java.util.Set;

import com.spanish.english.form.Phone;

public interface PhoneDao {
   boolean addOrUpdatePhone(Phone phone);
   boolean deletePhone(long phoneId);
   Phone getPhonebyId(long phoneId);
   Phone getLastPhone();
   Set<Phone> getPhoneListByAdmin(long adminId);
   Set<Phone> getPhoneListByOperator(long operatorId);
   Set<Phone> getPhoneListByEstablishment(long establishmentId);
   Set<Phone> getPhoneListByTechnician(long technicianId);
}

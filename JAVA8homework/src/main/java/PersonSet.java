import entity.Address;
import entity.Email;
import entity.MasterNumber;
import entity.Person;
import entity.Telephone;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonSet {
  private List<MasterNumber> masterNumbers;

  private List<Address> addresses;

  private List<Telephone> telephones;

  private List<Email> emails;

  public PersonSet() {}

  public PersonSet(List<MasterNumber> masterNumbers,
                   List<Telephone> telephones,
                   List<Address> addresses,
                   List<Email> emails) {
    this.masterNumbers = masterNumbers;
    this.addresses = addresses;
    this.telephones = telephones;
    this.emails = emails;
  }

  public Stream<Person> groupToPeople() {
    // TODO: group the data to Stream<Person>
    // Can use Collectors.groupingBy method
    // Can add helper method

    return this.masterNumbers.stream()
            .distinct()
            .map(MasterNumber::getNumber)
            .map((masterNumber)
                    -> new Person(masterNumber,
                    this.telephones.stream()
                            .collect(Collectors.groupingBy(Telephone::getMasterNumber))
                            .getOrDefault(masterNumber, new ArrayList<>()),
                    this.checkAddressPresent(this.addresses.stream()
                            .collect(Collectors.groupingBy(Address::getMasterNumber))
                            .get(masterNumber)),
                    this.emails.stream()
                            .collect(Collectors.groupingBy(Email::getMasterNumber))
                            .getOrDefault(masterNumber, new ArrayList<>())
            ))
            ;
  }

  public Address checkAddressPresent(List<Address> addresses) {
    if (Objects.isNull(addresses)) {
      return null;
    } else {
      return addresses.get(0);
    }
  }


  public List<Address> getAddresses() {
    return addresses;
  }

  public List<Telephone> getTelephones() {
    return telephones;
  }

  public List<Email> getEmails() {
    return emails;
  }

  public void setMasterNumbers(List<MasterNumber> masterNumbers) {
    this.masterNumbers = masterNumbers;
  }

  public void setAddresses(List<Address> addresses) {
    this.addresses = addresses;
  }

  public void setEmails(List<Email> emails) {
    this.emails = emails;
  }

  public void setTelephones(List<Telephone> telephones) {
    this.telephones = telephones;
  }
}

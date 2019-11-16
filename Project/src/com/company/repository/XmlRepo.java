package com.company.repository;

import com.company.entity.Entity;
import com.company.exception.ValidationException;
import org.jetbrains.annotations.Nullable;

import java.beans.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;

public class XmlRepo<ID, E extends Entity<ID>> extends AbstractRepository<ID,E>{

  private String filename;
  public XmlRepo(String filename) {
    super();
    this.filename = "src/com/company/files/"+filename;
    readXml();
  }

  private void writeXml() {
    try (FileOutputStream fos = new FileOutputStream(filename)) {
      XMLEncoder encoder = new XMLEncoder(fos);
      encoder.setPersistenceDelegate(LocalDateTime.class,
          new PersistenceDelegate() {
            @Override
            protected Expression instantiate(Object obj, Encoder encdr) {
              LocalDateTime localDate = (LocalDateTime) obj;
              return new Expression(localDate,
                  LocalDateTime.class,
                  "of",
                  new Object[]{localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth(),localDate.getHour(), localDate.getMinute(), localDate.getSecond()});
            }});
      encoder.writeObject(getStorage());
      encoder.close();
    } catch (IOException err) {
      System.out.println(err.getMessage());
    }
  }

  @SuppressWarnings("unchecked")
  private void readXml() {
    try(FileInputStream fis = new FileInputStream(filename)) {
      XMLDecoder decoder = new XMLDecoder(fis);
      HashMap<ID, E> map = (HashMap<ID, E>) decoder.readObject();
      setStorage(map);
      decoder.close();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  public E save(E entity) throws ValidationException {
    E aux = super.save(entity);
    this.writeXml();
    return aux;
  }

  @Override
  public E delete(@Nullable ID id) {
    E aux = super.delete(id);
    this.writeXml();
    return aux;
  }

  @Override
  public E update(@Nullable E entity) throws ValidationException {
    E aux = super.update(entity);
    this.writeXml();
    return aux;
  }
}

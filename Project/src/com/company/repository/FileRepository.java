package com.company.repository;

import com.company.entity.Entity;
import com.company.exception.ValidationException;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.PrintWriter;

public abstract class FileRepository<ID,E extends Entity<ID>> extends AbstractRepository<ID,E> {
    private final Object e = new Object();
    protected String filename;
    FileRepository(String filename) {
        super();
        this.filename = filename;
        loadFile();
    }

    @SuppressWarnings("unchecked")
    abstract void loadFile();

    private void saveFile() {
        try (PrintWriter pw = new PrintWriter(filename)) {
            for (E x: findAll()) {
                pw.println(x.toFile());
            }
        } catch (IOException err) {
            System.out.println(err.getMessage());
        }
    }

    @Override
    public E save(E entity) throws ValidationException {
        E aux = super.save(entity);
        this.saveFile();
        return aux;
    }

    @Override
    public E delete(@Nullable ID id) {
        E aux = super.delete(id);
        this.saveFile();
        return aux;
    }

    @Override
    public E update(@Nullable E entity) throws ValidationException {
        E aux = super.update(entity);
        this.saveFile();
        return aux;
    }
}

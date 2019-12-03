using System.Collections;
using System;
using System.IO;
using System.Text;
interface ICrudRepository<ID, T> {
	void save(T t);
  T delete(ID id);
  int size();
  T findOne(ID id);
  IEnumerable<T> findAll();
}

class Entity<ID>
{
  ID id { get; }
}

class Book : Entity<int>
{
  public string author { get; set; }
  public string title { get; set; }
  public bool isPaperback { get; set; }
  public double price { get; set; }

  public Book(int id, string title, string author, bool isPapaperback, double price): base(id)
  {
    this.author = author;
    this.title = title;
    this.isPaperback = isPaperback;
    this.price = price;
  }

  public override string ToString()
  {
    return $"{title} by {author}: {price}";
  }
  public string ToFile()
  {
    return $"{id};{title};{author};{isPaperback};{price}";
  }
}


interface ICrudRepository<ID,T> {
	void save(T t);
	T delete(ID id);
	int size();
	T findOne(ID id);
	IEnumerable<T> findAll();
}

interface IValidator<E> {
	void validate();
}

class RepoException: ApplicationException {
	RepoException(): base() {}

	RepoException(String error): base(error) {}
}

public abstract class AbstractRepository<ID,T>:ICrudRepository<ID,T> where T:Entity<ID> {
	IDictionary <ID, T> elems;
	IValidator <T> validator;

	public AbstractRepository(IValidator<T> validator) {
		this.validator = validator;
		elems = new Dictionary<ID, T>();
	}

	public virtual void save(T t) {
    try {
		  validator.validate(t);
      if(elems.ContainsKey(t.Id))
        throw new RepoException("Elementul exista deja");
      elems.add(T.id, T);
    } catch (ValidationException err) {
      throw err;
    }
	}

  public virtual T delete(ID id) {
    if (!elems.ContainsKey(id))
      return default(T);
    T val = elems[id];
    elems.Remove(id);
    return val;
  }

  public T findOne(ID id) {
	  if(elems.ContainsKey(id))
	  	return elems[id];
    return default(T);
  }

  public IEnumerable<T> findAll() {
    return elems.Values;
  }

  public int size()
  {
    return elems.Count;
  }
}

public class BookRepo:AbstractRepository<int, Book>
{
  public BookRepo(IValidator<Book> valid): base(valid) { }
}

public class BookRepoFile:BookRepo
{
  private string fileName;

  public BookRepoFile(String fileName, IValidator<Book> val): base(val)
  {
    this.fileName = fileName;
    loadFile();
  }

  private void loadFile()
  {
    using(TextReader reader = File.OpenText(fileName))
    {
      string line;
      while(line = reader.ReadLine()) {
        string[] values = line.Split(';');
        if (values.Length != 5)
          continue;
        if (!(int.TryParse(values[0], out int id) && bool.TryParse(values[3], out bool isPaperback) && double.TryParse(values[4], out double price)))
          continue;
        base.save(new Book(id, values[1], values[2], isPaperback, price));
      }
    }
  }

  private void writeFile()
  {
    using(TextWriter writer = File.OpenWrite())
    {
      foreach(Book b in base.findAll())
      {
        writer.WriteLine(b.ToFile());
      }
    }
  }

  public override void save(Book t)
  {
    base.save(t);
    writeFile();
  }

  public override Book delete(int id)
  {
    var aux = base.delete(id);
    writeFile();
    return aux;
  }
}


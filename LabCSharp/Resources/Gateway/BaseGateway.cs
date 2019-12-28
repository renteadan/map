using System.Collections.Generic;
using System.Data.Linq;
using System.Linq;
using LabCSharp.Resources.Entity;

namespace LabCSharp.Resources.Gateway
{
	public class BaseGateway<T>:IGateway<T> where T: class, IBaseEntity
	{
		protected NBALeagueDataContext Context;
    protected Table<T> Table;

	  public BaseGateway()
	  {

      UpdateContext();
	  }

	  private void UpdateContext()
	  {
		  Context = new NBALeagueDataContext();
      Table = Context.GetTable<T>();
    }

	  public void InsertOne(T entity)
    {
	    Table.InsertOnSubmit(entity);
      Context.SubmitChanges();
      UpdateContext();
    }

    public T DeleteOne(T entity)
    {
      var aux = Table.First();
      var existing = Table.Single(item => item.Id.Equals(entity.Id));
      Table.DeleteOnSubmit(existing);
      Context.SubmitChanges();
      UpdateContext();
      return aux;
    }

    public T UpdateOne(T entity)
    {
      var aux = Table.First();
      Table.Attach(entity);
      Table.DeleteOnSubmit(entity);
      Table.InsertOnSubmit(entity);
      Context.SubmitChanges();
      UpdateContext();
      return aux;
    }

    public T FindOne(T entity)
    {
	    UpdateContext();
      return Table.First(k => k.Id.Equals(entity.Id));
    }
    public List<T> GetAll()
    {
	    UpdateContext();
      var query = from entity in Table
                   where entity != null
                   select entity;
      return query.ToList();
    }

    public IEnumerable<T> GetAllExcept(IEnumerable<T> except, IEqualityComparer<T> comparer)
    {
	    EntitySet<T> set = new EntitySet<T>();
	    set.SetSource(GetAll());
	    return set.Except(except, comparer);
    }
  }
}

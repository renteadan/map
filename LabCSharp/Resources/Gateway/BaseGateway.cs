using System.Collections.Generic;
using System.Data.Linq;
using System.Linq;
using LabCSharp.Resources.Entity;

namespace LabCSharp.Resources.Gateway
{
	public class BaseGateway<T>:IGateway<T> where T: class, IBaseEntity
  {
    protected readonly NBALeagueDataContext Context = new NBALeagueDataContext();
    protected readonly Table<T> Table;
    public BaseGateway()
    {
      Table = Context.GetTable<T>();
    }

    public void InsertOne(T entity)
    {
      Table.InsertOnSubmit(entity);
      Context.SubmitChanges();
    }

    public T DeleteOne(T entity)
    {
      T aux = Table.First<T>();
      Table.DeleteOnSubmit(entity);
      Context.SubmitChanges();
      return aux;
    }

    public T UpdateOne(T entity)
    {
      T aux = Table.First<T>();
      Table.Attach(entity);
      Table.DeleteOnSubmit(entity);
      Table.InsertOnSubmit(entity);
      Context.SubmitChanges();
      return aux;
    }

    public T FindOne(T entity)
    {
      return Table.First(k => k.Id.Equals(entity.Id));
    }
    public List<T> GetAll()
    {
      var query = from entity in Table
                   where entity != null
                   select entity;
      return query.ToList();

    }
  }
}

using LabCSharp;
using System.Linq;
using System.Data.Linq;
using System;
using System.Collections.Generic;
using System.Data;
using LabCSharp.Entity;

namespace LabCSharp.Gateway
{
  public delegate T fromDataPacket<T>(string s);
  public class BaseGateway<T>:IGateway<T> where T: class, IBaseEntity
  {
    private NBALeagueDataContext Context = new NBALeagueDataContext();
    private Table<T> Table;
    public BaseGateway()
    {
      Table = Context.GetTable<T>();
    }

    public void InsertOne(T Entity)
    {
      Table.InsertOnSubmit(Entity);
      Context.SubmitChanges();
    }

    public T DeleteOne(T Entity)
    {
      T Aux = Table.First<T>();
      Table.DeleteOnSubmit(Entity);
      Context.SubmitChanges();
      return Aux;
    }

    public T UpdateOne(T Entity)
    {
      T Aux = Table.First<T>();
      Table.Attach(Entity);
      Table.DeleteOnSubmit(Entity);
      Table.InsertOnSubmit(Entity);
      Context.SubmitChanges();
      return Aux;
    }

    public T FindOne(T Entity)

    {
      return Table.First(k => k.Id.Equals(Entity.Id));
    }
    public List<T> GetAll()
    {
      var querry = from entity in Table
                   where entity is T
                   select entity;
      return querry.ToList();

    }
  }
}

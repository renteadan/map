using System.Collections.Generic;
using LabCSharp.Resources.Entity;
using LabCSharp.Resources.Gateway;
using LabCSharp.Resources.Validator;

namespace LabCSharp.Resources.Service
{
	class BaseService<T> : IService<T> where T: class, IBaseEntity
	{
		protected BaseGateway<T> Gateway;
		protected readonly IValidator<T> Validator;
		public BaseService() {
			Gateway = new BaseGateway<T>();
			Validator = new Validator<T>();
		}

		public BaseService(BaseGateway<T> gateway, IValidator<T> validator)
		{
			Gateway = gateway;
			Validator = validator;
		}
		public T DeleteOne(T entity)
		{
			return Gateway.DeleteOne(entity);
		}

		public T FindOne(T entity)
		{
			return Gateway.FindOne(entity);
		}

		public List<T> GetAll()
		{
			return Gateway.GetAll();
		}

		public void InsertOne(T entity)
		{
			Validator.Validate(entity);
			Gateway.InsertOne(entity);
		}

		public T UpdateOne(T entity)
		{
			Validator.Validate(entity);
			return Gateway.UpdateOne(entity);
		}

		public IEnumerable<T> GetAllExcept(IEnumerable<T> except, IEqualityComparer<T> comparer)
		{
			return Gateway.GetAllExcept(except, comparer);
		}
	}
}

using LabCSharp.Entity;
using LabCSharp.Exception;
using LabCSharp.Gateway;
using LabCSharp.Validator;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LabCSharp.Service
{
	class BaseService<T> : IService<T> where T: class, IBaseEntity
	{
		BaseGateway<T> Gateway;
		Validator<T> Validator;
		public BaseService() {
			Gateway = new BaseGateway<T>();
			Validator = new Validator<T>();
		}

		public BaseService(BaseGateway<T> Gateway, Validator<T> Validator)
		{
			this.Gateway = Gateway;
			this.Validator = Validator;
		}
		public T DeleteOne(T Entity)
		{
			return Gateway.DeleteOne(Entity);
		}

		public T FindOne(T Entity)
		{
			return Gateway.FindOne(Entity);
		}

		public List<T> GetAll()
		{
			return Gateway.GetAll();
		}

		public void InsertOne(T Entity)
		{
			Validator.Validate(Entity);
			Gateway.InsertOne(Entity);
		}

		public T UpdateOne(T Entity)
		{
			Validator.Validate(Entity);
			return Gateway.UpdateOne(Entity);
		}
	}
}

namespace LabCSharp.Resources.Validator
{
	public class Validator<T> : IValidator<T> where T: class
	{
		public virtual void Validate(T entity)
		{
			if (entity == null)
				throw new System.NullReferenceException();
		}

	}
}

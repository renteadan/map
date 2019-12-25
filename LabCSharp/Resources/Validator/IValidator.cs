namespace LabCSharp.Resources.Validator
{
	interface IValidator<in T> where T: class
	{
		void Validate(T entity);
	}
}

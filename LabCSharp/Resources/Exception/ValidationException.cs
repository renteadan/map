namespace LabCSharp.Resources.Exception
{
	class ValidationException: System.Exception
	{
		public ValidationException(string message): base(message) { }
		public ValidationException(): base() { }
	}
}

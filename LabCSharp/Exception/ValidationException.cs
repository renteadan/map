using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LabCSharp.Exception
{
	class ValidationException: System.Exception
	{
		public ValidationException(string Message): base(Message) { }
		public ValidationException(): base() { }
	}
}

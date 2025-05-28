package Feedbackpackage;

public class FeedbackModel {

		private int Id;
		private String Name;
		private String Email;
		private String Subject;
		private String Message;
		
		public FeedbackModel(int Id, String Name, String Email, String Subject, String Message) {
			
			this.Id = Id;
			this.Name = Name;
			this.Email = Email;
			this.Subject = Subject;
			this.Message = Message;
			
		}

		public int getId() {
			return Id;
		}

		public void setId(int Id) {
			this.Id = Id;
		}

		public String getName() {
			return Name;
		}

		public void setName(String Name) {
			this.Name = Name;
		}

		public String getEmail() {
			return Email;
		}

		public void setEmail(String Email) {
			this.Email = Email;
		}

		public String getSubject() {
			return Subject;
		}

		public void setSubject(String Subject) {
			this.Subject = Subject;
		}

		public String getMessage() {
			return Message;
		}

		public void setMessage(String Message) {
			this.Message = Message;
		}


	}

	



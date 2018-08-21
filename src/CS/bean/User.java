package CS.bean;

public class User {
		private String id;
		private String name;
		private String password1;
		private String password2;
		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", password1="
					+ password1 + ", password2=" + password2 + "]";
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPassword1() {
			return password1;
		}
		public void setPassword1(String password1) {
			this.password1 = password1;
		}
		public String getPassword2() {
			return password2;
		}
		public void setPassword2(String password2) {
			this.password2 = password2;
		}
		public User() {
			super();
		}
		public User(String id, String name, String password1, String password2) {
			super();
			this.id = id;
			this.name = name;
			this.password1 = password1;
			this.password2 = password2;
		}
		
		
}

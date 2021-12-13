<template>
  <div id="app" class="app">
    <div class="header">
      <h1>Heladeria UN</h1>
      <nav>
        <div>
        <button v-if="is_auth" v-on:click="loadHome">Inicio</button>
        <button v-if="is_auth" v-on:click="loadAccount"> Cuenta </button>
        <button v-if="is_auth" v-on:click="logOut">Cerrar Sesión</button>
        <button v-if="!is_auth" v-on:click="loadLogIn">Iniciar Sesión</button>
        <button v-if="!is_auth" v-on:click="loadSignUp">Registrarse</button>
        </div>
        <div>
        <input v-if="is_auth" type="number" v-model="bill_id" placeholder = 0>
        <button v-if="is_auth" v-on:click="loadBill"> Consultar Factura </button>
      </div>
      </nav>
    </div>
    <div class="main-component">
      <router-view
        v-on:completedLogIn="completedLogIn"
        v-on:completedSignUp="completedSignUp"
        v-on:logOut="logOut"
      >
      </router-view>
    </div>
    <div class="footer">
      <h2>Misión TIC 2022</h2>
    </div>
  </div>
</template>

<script>
export default {
  name: "App",
  data: function () {
    return {
      bill_id: "0",
      is_auth: false,
    };
  },
  components: {},
  methods: {
    verifyAuth: function () {
      this.is_auth = localStorage.getItem("isAuth") || false;
      if (this.is_auth == false) this.$router.push({ name: "logIn" });
      else this.$router.push({ name: "home" });
    },
    // selectId: function(){
    //   return this.bill_id
    // },
    loadHome: function () {
      this.$router.push({ name: "home" });
    },
    logOut: function () {
      localStorage.clear();
      alert("Sesión Cerrada");
      this.verifyAuth();
    },
    loadAccount: function () {
      localStorage.setItem("selectId", this.bill_id);
      this.$router.push({ name: "account" });
    },
    loadBill: function () {
      localStorage.setItem("selectId", this.bill_id);
      this.$router.push({ name: "bill" });
    },
    loadLogIn: function () {
      this.$router.push({ name: "logIn" });
    },
    loadSignUp: function () {
      this.$router.push({ name: "signUp" });
    },
    completedLogIn: function (data) {
      localStorage.setItem("isAuth", true);
      localStorage.setItem("username", data.username);
      localStorage.setItem("token_access", data.token_access);
      localStorage.setItem("token_refresh", data.token_refresh);
      alert("Autenticación Exitosa");
      this.verifyAuth();
    },
    completedSignUp: function (data) {
      alert("Registro Exitoso");
      this.completedLogIn(data);
    },
  },
  created: function () {
    this.verifyAuth();
  },
};
</script>

<style>
body {
  margin: 0 0 0 0;
}
.header {
  margin: 0%;
  padding: 0;
  width: 100%;
  height: 10vh;
  min-height: 100px;
  background-color: #A918F2;
  color: #F18F01;
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.header h1 {
  width: 20%;
  text-align: center;
}
.header nav {
  height: 100%;
  width: 20%;
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  align-items: center;
  font-size: 20px;
}
.header div{
  display: flex;
  justify-content: space-evenly;
  padding-right: 20px

}
.header input{
  width: 100px;
}
.header nav button {
  color: #F18F01;
  background: #A918F2;
  border: 1px solid #F18F01;
  border-radius: 5px;
  padding: 10px 20px;
}
.header nav button:hover {
  color: #A918F2;
  background: #F18F01;
  border: 1px solid #F18F01;
}
.main-component {
  height: 75vh;
  margin: 0%;
  padding: 0%;
  background: #6eb8d8;
}
.footer {
  margin: 0;
  padding: 0;
  width: 100%;
  height: 10vh;
  min-height: 100px;
  background-color: #A918F2;
  color: #F18F01;
}
.footer h2 {
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
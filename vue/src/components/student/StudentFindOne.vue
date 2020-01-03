<template> 
	<div class="login-form">
    <form>
        <h2 class="text-center">학번 검색</h2>       
        <div class="form-group">
            <input v-model="searchWord" type="text" class="form-control" placeholder="Username" required="required">
        </div>
        <div class="form-group">
            <button @click.prevent="find" type="submit" class="btn btn-primary btn-block">전 송</button>
        </div>
    </form>
	</div>
	<!--
	-->
</template>
<script>
import axios from 'axios'
export default{
	data(){
		return {
			context: 'http://localhost:8080/',
			list: []
		}
	},
	created(){
		axios
		.get(`${this.context}/students`)
		.then(res =>{
			this.list = res.data
		})
		.catch(e=>{
			alert('AXIOS FAIL'+e)
		})
	}
}
</script>
<style scoped>
.table{border : 1px solid black}
.table tr{border : 1px solid black}
.table tr th{border : 1px solid black}
.table tr td{border : 1px solid black}
.login-form {
    width: 340px;
    margin: 50px auto;
}
.login-form form {
    margin-bottom: 15px;
    background: #f7f7f7;
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    padding: 30px;
}
.login-form h2 {
    margin: 0 0 15px;
}
.form-control, .btn {
    min-height: 38px;
    border-radius: 2px;
}
.btn {        
    font-size: 15px;
    font-weight: bold;
}
</style>
import axios from 'axios'
import Constant from '@/store/modules/mutation_types'

export default {
  async login (data) {
    alert(`테스트 ${self} ,  ${data.userid},${data.passwd}` )
            
            let url = `${data.context}login`
            alert('>>>>>>'+url)
            let headers = {
                'authorization': 'JWT fefege..',
                'Accept' : 'application/json',
                'Content-Type': 'application/json'
            }
            axios
            .post(url, data, headers)
            .then(res=>{
                if(res.data.result === "SUCCESS"){
                  alert(`로그인 2020 성공`)
                  this.$store.commit(Constant.PERSON, res.data.person)
                  this.$store.commit(Constant.IS_AUTH, true)
                  
                  alert(`스토어에 저장성공 ${this.$store.state.authCheck}`)
                  if(this.$store.state.person.role !== 'student'){
                      this.$store.commit(Constant.SIDEBAR, 'managerSidebar')
                      this.$store.commit(Constant.HEADER_MESSAGE, '관리자화면')
                      this.$router.push({path: '/admin'})
                  }else{
                      this.$store.commit(Constant.SIDEBAR, 'studentSidebar')
                      this.$store.commit(Constant.HEADER_MESSAGE, '학생화면')
                      this.$router.push({path: '/myPage'})
                  }
                  
                }else{
                  alert(`로그인실패`)
                  this.$router.push({path: '/login'})
                }
            })
            .catch(()=>{
                alert('AXIOS 실패')
            })  
  }
}
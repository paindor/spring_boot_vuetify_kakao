  
import loginAPI from '@/api/loginAPI'

export default {
  async login (uid, password) {
    try {
      const loginResponse = await loginAPI.login(uid, password)
      return loginResponse
    } catch (err) {
      alert(err)
    }
  }
}
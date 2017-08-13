<?php

namespace app\models;

use Yii;

/**
 * This is the model class for table "users".
 *
 * @property integer $user_id
 * @property string $username
 * @property string $password
 * @property string $secret_key
 * @property string $user_device_id
 * @property string $email
 * @property integer $role_id
 * @property string $registered_date
 * @property integer $is_active
 * @property string $last_logged_in
 * @property integer $mobile
 * @property string $notification_token
 */
class Users extends \yii\db\ActiveRecord
{
    const SCENARIO_CREATE = 'create';
    const SCENARIO_LOGIN = 'login';

    /**
     * @inheritdoc
     */
    public static function tableName()
    {
        return 'users';
    }

    /**
     * @inheritdoc
     */
    public function rules()
    {
        return [
            [['username', 'password', 'secret_key', 'role_id'], 'required'],
            [['username', 'password', 'secret_key', 'user_device_id', 'email', 'registered_date', 'last_logged_in', 'notification_token'], 'string'],
            [['role_id', 'is_active', 'mobile'], 'integer'],
            [['mobile'],'string','min'=>10],
	    [['mobile'],'string','max'=>10],
            [['username'], 'unique','on'=>'create'],
         ];
    }

    /**
     * @inheritdoc
     */
    public function attributeLabels()
    {
        return [
            'user_id' => 'User ID',
            'username' => 'Username',
            'password' => 'Password',
            'secret_key' => 'Secret Key',
            'user_device_id' => 'User Device ID',
            'email' => 'Email',
            'role_id' => 'Role ID',
            'registered_date' => 'Registered Date',
            'is_active' => 'Is Active',
            'last_logged_in' => 'Last Logged In',
            'mobile' => 'Mobile',
            'notification_token' => 'Notification Token',
        ];
    }
    
    public function scenarios() {
        $scenarios = parent::scenarios();
        $scenarios['create'] = ['username', 'password', 'secret_key', 
            'user_device_id', 'email', 'registered_date', 
            'last_logged_in', 'notification_token','role_id', 
            'is_active', 'mobile'];
        $scenarios['login'] = ['username', 'password'];
        return $scenarios;
    }
    
    public function hasUser($username,$password){
       
        $user = Users::findOne(['username' => $username]);
        
        if($user == null){
            return FALSE;
        }elseif (Yii::$app->getSecurity()->validatePassword($password, $user->password)) {
            return TRUE;
        }else{
            return FALSE;
        }
    }
    
    public function getUserByName($username){
        return Users::findOne(['username' => $username]);
    }

    public function getCurrentTimeInMili(){
        return strval(time()*1000);
    }
}

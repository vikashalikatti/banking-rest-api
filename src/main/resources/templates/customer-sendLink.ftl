<html xmlns="http://www.w3.org/1999/xhtml">
<body style="margin: 0; padding: 0; background-color: #F2F3F5;">
    <table align="center" border="0" cellpadding="0" cellspacing="0" width="600" style="margin: 30px auto; background-color: #ffffff; border-radius: 15px;">
        <tr>
            <td align="center" bgcolor="#1E90FF" style="padding: 40px; color: #ffffff; font-size: 28px; font-weight: bold; border-top-left-radius: 15px; border-top-right-radius: 15px; border-bottom: 3px solid #00529B;">Welcome to Your Banking Account</td>
        </tr>
        <tr>
            <td align="center" style="padding: 30px;"><img src="https://t3.ftcdn.net/jpg/04/55/50/32/360_F_455503238_nZdUem3qdEhLHWHGvh147o0nT6rLil1V.jpg" alt="Bank Logo" width="550" height="170"></td>
        </tr>
        <tr>
            <td style="padding: 20px; color: #333; font-size: 18px; line-height: 1.5; border-bottom: 2px solid #1E90FF;">
                <p style="font-size: 24px; font-weight: bold; color: #1E90FF;">Hello ${genderPrefix}, ${customer.getName()},</p>
                <p>Welcome to your banking account at Example Bank. We're pleased to have you as our valued customer!</p>
                <p>With our banking services, you can manage your finances, make transactions, and more.</p>
                <p>This link is valid for 5 minutes. Please use it within this time frame to complete your account setup.</p>
                <p>Valid Till: ${formattedOTPExpirationTime}</p>
                <center>
                    <a href="http://localhost:8080/banking/verify-otp/${email}/${token}">
                        <button style="background-color: #1E90FF; color: white; border: none; padding: 10px 20px; border-radius: 5px; cursor: pointer;">
                            Click Here to Verify
                        </button>
                    </a>
                </center>
            </td>
        </tr>
        <tr>
            <td align="center" bgcolor="#F2F3F5" style="padding: 20px; color: #888; font-size: 14px; border-bottom-left-radius: 15px; border-bottom-right-radius: 15px;">&copy; 2023 Welcome to Example Bank</td>
        </tr>
    </table>
</body>
</html>

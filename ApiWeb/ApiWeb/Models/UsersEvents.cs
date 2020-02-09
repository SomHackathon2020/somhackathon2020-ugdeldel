using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ApiWeb.Models
{
    public class UsersEvents
    {
        public int Id { get; set; }
        public int UsersId { get; set; }
        public int EventsId { get; set; }
    }
}

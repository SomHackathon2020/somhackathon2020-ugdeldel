using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using ApiWeb.Models;

namespace ApiWeb.Data
{
    public class ApiWebContext : DbContext
    {
        public ApiWebContext (DbContextOptions<ApiWebContext> options)
            : base(options)
        {
        }

        public DbSet<ApiWeb.Models.Events> Events { get; set; }

        public DbSet<ApiWeb.Models.Users> Users { get; set; }
    }
}
